package com.bnz.db.rocketmq;

import com.bnz.db.service.WebSocketServer;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * DESC:  消费者
 *
 * @author DB
 * @create 2020-10-08 15:42
 */
@Service
@RocketMQMessageListener(topic = "article_system_topic", consumerGroup = "article_system_consumer")
public class Consumer implements RocketMQListener<Object> {
	@Autowired
	private WebSocketServer webSocketServer;


	@Override
	public void onMessage(Object message) {
		HashMap map = (HashMap) message;
		webSocketServer.sendInfo(map.get("userId").toString(), message.toString());
		System.out.println(message);
	}
}
