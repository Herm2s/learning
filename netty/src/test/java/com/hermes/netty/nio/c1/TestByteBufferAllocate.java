package com.hermes.netty.nio.c1;

import java.nio.ByteBuffer;

public class TestByteBufferAllocate {
    public static void main(String[] args) {
        // 分配的是堆内存，读写效率较低，收到GC影响
        System.out.println(ByteBuffer.allocate(16).getClass());
        // 分配的是直接内存，读写效率高（少一次拷贝），不受GC影响，但是分配效率低。
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
    }
}
