package com.hermes.netty.nio.c1;

import java.nio.ByteBuffer;


public class TestByteBufferReadWrite {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 测试put
        buffer.put((byte) 0x61); // 'a'
        ByteBufferUtil.debugAll(buffer);
        buffer.put(new byte[]{0x62, 0x63, 0x64}); // b c d
        ByteBufferUtil.debugAll(buffer);

        // 测试flip
        buffer.flip();
        System.out.println(buffer.get());
        ByteBufferUtil.debugAll(buffer);

        // 测试compact
        buffer.compact();
        ByteBufferUtil.debugAll(buffer);
        // 调用compact后再写入
        buffer.put(new byte[]{0x65, 0x66});
        ByteBufferUtil.debugAll(buffer);
    }
}
