package com.hermes.netty.message;

public class PongMessage extends Message {
    @Override
    public int getMessageType() {
        return PONG_MESSAGE;
    }
}
