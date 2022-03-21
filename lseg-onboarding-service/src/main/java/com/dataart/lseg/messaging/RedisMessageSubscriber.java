package com.dataart.lseg.messaging;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisMessageSubscriber implements MessageListener {

    public static List<String> messageList = new ArrayList<String>();

    public void onMessage(final Message message, final byte[] pattern) {
        String stringMessage = message.toString();
        if (messageList.contains(stringMessage)) {
            messageList.remove(stringMessage);
        } else {
            messageList.add(message.toString());
        }
    }
}
