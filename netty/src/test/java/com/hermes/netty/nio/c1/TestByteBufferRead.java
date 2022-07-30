package com.hermes.netty.nio.c1;

import java.nio.ByteBuffer;

public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();

        // rewind 从头开始读
       /* buffer.get(new byte[4]);
        ByteBufferUtil.debugAll(buffer);
        buffer.rewind();
        System.out.println((char) buffer.get());*/

        // mark & reset
        // mark 做一个标记，记录position位置， reset是将position重置到mark的位置
  /*      System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.mark(); // 加标记
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());
        buffer.reset(); // 重置
        System.out.println((char) buffer.get());
        System.out.println((char) buffer.get());*/

        // get(i) 不会改变索引的位置
        System.out.println((char) buffer.get(3));
        ByteBufferUtil.debugAll(buffer);
    }
}
