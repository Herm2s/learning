package com.hermes.netty.nio.c4;

import com.hermes.netty.nio.c1.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Slf4j
public class AioFileChannel {

    public static void main(String[] args) throws IOException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("data.txt"), StandardOpenOption.READ);
        // 参数1 ByteBuffer
        // 参数2 读取的起始位置
        // 参数3 附件
        // 参数4 回调对象
        ByteBuffer buffer = ByteBuffer.allocate(16);
        log.debug("read begin...");
        channel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                // 读取完成后
                log.debug("read completed...");
                attachment.flip();
                ByteBufferUtil.debugAll(attachment);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                // 读取异常时
                exc.printStackTrace();
            }
        });
        log.debug("read end...");
        System.in.read();
    }
}
