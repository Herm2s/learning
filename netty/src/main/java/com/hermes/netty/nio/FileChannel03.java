package com.hermes.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 拷贝文件
 *
 * @author liuzongbin
 * @date 2021/11/10
 */
public class FileChannel03 {

    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("d:\\1.txt");
        FileChannel inputChannel = inputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream("d:\\2.txt");
        FileChannel outputChannel = outputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            // ⭐重要⭐清除缓冲区
            byteBuffer.clear();
            // 从input channel中读数据到buffer
            int read = inputChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            // 将buffer中的数据写到output channel
            byteBuffer.flip();
            outputChannel.write(byteBuffer);
        }
    }
}
