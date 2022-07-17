package com.hermes.netty.nio.c4;

import com.hermes.netty.nio.c1.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MultiThreadServer {

    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("Boss");
        try (ServerSocketChannel ssc = ServerSocketChannel.open()) {
            ssc.bind(new InetSocketAddress(8080));
            ssc.configureBlocking(false);

            Selector boss = Selector.open();
            SelectionKey bossKey = ssc.register(boss, 0, null);
            bossKey.interestOps(SelectionKey.OP_ACCEPT);
            // 1. 创建固定数量的work并初始化
            Worker[] workers = new Worker[6];
            for (int i = 0; i < workers.length; i++) {
                workers[i] = new Worker("work-" + i);
            }
            AtomicInteger index = new AtomicInteger();
            while (true) {
                boss.select();
                Iterator<SelectionKey> iterator = boss.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    if (key.isAcceptable()) {
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        log.debug("connected...{}", sc.getRemoteAddress());
                        // 2. 关联selector
                        log.debug("before register...{}", sc.getRemoteAddress());
                        // round robin
                        workers[index.incrementAndGet() % workers.length].register(sc); // boss线程
                        log.debug("after register...{}", sc.getRemoteAddress());
                    }
                }
            }
        }
    }

    static class Worker implements Runnable {
        private Thread thread;

        private Selector selector;

        private String name;

        private volatile boolean started = false;

        private ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();

        public Worker(String name) {
            this.name = name;
        }

        /**
         * 初始化线程和selector
         */
        public void register(SocketChannel sc) throws IOException {
            if (!started) {
                this.thread = new Thread(this, name);
                this.thread.start();
                this.selector = Selector.open();
                this.started = true;
            }
            // 向队列添加任务，但这个任务并没有立即执行
            this.queue.add(() -> {
                try {
                    sc.register(this.selector, SelectionKey.OP_READ, null);
                } catch (ClosedChannelException e) {
                    throw new RuntimeException(e);
                }
            });
            // 唤醒select方法
            this.selector.wakeup();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    this.selector.select(); // work线程
                    Runnable task = this.queue.poll();
                    if (task != null) {
                        // 注意，直接调用run方法并不会开启一个新线程，所以这行代码还是在work线程里执行
                        task.run();
                    }
                    Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();
                        iterator.remove();
                        if (key.isReadable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(16);
                            SocketChannel channel = (SocketChannel) key.channel();
                            log.debug("read...{}", channel.getRemoteAddress());
                            channel.read(buffer);
                            buffer.flip();
                            ByteBufferUtil.debugAll(buffer);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
