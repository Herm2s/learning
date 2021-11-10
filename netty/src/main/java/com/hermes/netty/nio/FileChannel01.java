package com.hermes.netty.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * 写数据到文件
 */
public class FileChannel01 {

    public static void main(String[] args) throws IOException {
        String str = "hello, NIO";
        // 创建一个输出流
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\1.txt");
        // 通过输出流获取对应的文件Channel，真实类型是FileChannelImpl
        FileChannel channel = fileOutputStream.getChannel();
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put(str.getBytes(StandardCharsets.UTF_8));
        // 对byteBuffer进行flip
        byteBuffer.flip();
        // 把缓冲区的数据写入Channel
        channel.write(byteBuffer);
        fileOutputStream.close();
    }
}
