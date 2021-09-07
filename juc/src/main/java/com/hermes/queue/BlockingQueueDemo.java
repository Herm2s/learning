package com.hermes.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzongbin
 * @version 1.0
 * @date 2021/9/5
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建阻塞队列
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        // 第一组：异常组
        // add()：队列未满时插入元素，成功返回true，队列已满抛出IllegalStateException
        System.out.println(blockingQueue.add("a")); // --> true
        System.out.println(blockingQueue.add("b")); // --> true
        System.out.println(blockingQueue.add("c")); // --> true
        //        System.out.println(blockingQueue.element()); // --> a
        //        System.out.println(blockingQueue.add("d"));  // --> IllegalStateException

        // remove()：取出并移除队列头部元素，如果此队列为空，抛出NoSuchElementException
        System.out.println(blockingQueue.remove()); // --> a
        System.out.println(blockingQueue.remove()); // --> b
        System.out.println(blockingQueue.remove()); // --> c
        //        System.out.println(blockingQueue.remove()); // --> NoSuchElementException

        // 第二组：特殊返回组
        // offer()：队列未满时插入元素，成功返回true，队列已满返回false
        System.out.println(blockingQueue.offer("a")); // --> true
        System.out.println(blockingQueue.offer("b")); // --> true
        System.out.println(blockingQueue.offer("c")); // --> true
        //        System.out.println(blockingQueue.offer("d")); // --> false

        // poll()：取出并移除此队列的头部，如果此队列为空，则返回null 。
        System.out.println(blockingQueue.poll()); // --> a
        System.out.println(blockingQueue.poll()); // --> b
        System.out.println(blockingQueue.poll()); // --> c
        System.out.println(blockingQueue.poll()); // --> null

        // 第三组：阻塞组
        // put()：将指定的元素插入此队列，队列已满时会阻塞。
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //        blockingQueue.put("d"); // --> Condition.await()

        // take()：取出并移除此队列的头部，队列为空时会阻塞。
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //        System.out.println(blockingQueue.take()); // --> Condition.await()

        // 第四组：超时组
        // offer(E e, long timeout, TimeUnit unit)：将元素插入此队列，队列已满时等待指定的等待时间，超时则放弃。
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        //        System.out.println(blockingQueue.offer("d", 3, TimeUnit.SECONDS)); // --> 等待3s后结束，Condition.awaitNanos

        // poll(long timeout, TimeUnit unit)：检索并移除此队列的头部，队列为空时，等待指定的等待时间，超时则放弃，返回null。
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(3, TimeUnit.SECONDS));  // --> 等待3s后返回null，Condition.awaitNanos
    }
}
