package com.hermes.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        // 1. 创建一个线程池
        // 2. 如果有客户端连接，就创建一个线程与之通信
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        // 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务器启动了");
        while (true) {
            // 监听，等待客户端连接
            // 阻塞
            System.out.println("等待连接...");
            final Socket socket = serverSocket.accept();
            System.out.println("连接到一个客户端");
            // 创建线程与之通信
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    // 可以和客户端通讯
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        byte[] bytes = new byte[1024];
        System.out.println("线程ID：" + Thread.currentThread().getId()
                + "  名字：" + Thread.currentThread().getName());
        try {
            // 通过socket获取输入流
            InputStream inputStream = socket.getInputStream();
            // 循环读取客户端发送的数据
            while (true) {
                // 阻塞
                System.out.println("read...");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    // 输出客户端发送的数据
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("关闭和client的连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
