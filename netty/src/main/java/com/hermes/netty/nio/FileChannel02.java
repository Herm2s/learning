package com.hermes.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件读数据
 *
 * @author liuzongbin
 * @date 2021/11/10
 */
public class FileChannel02 {

    public static void main(String[] args) throws IOException {
        // 创建文件的输入流
        File file = new File("d:\\1.txt");
        FileInputStream inputStream = new FileInputStream(file);
        // 获取Channel
        FileChannel channel = inputStream.getChannel();
        // 创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        // 将通道的数据读入到buffer中
        channel.read(byteBuffer);
        System.out.println(new String(byteBuffer.array()));
        inputStream.close();
    }
}
