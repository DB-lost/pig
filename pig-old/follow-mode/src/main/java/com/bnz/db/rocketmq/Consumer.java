package com.bnz.db.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * DESC:  消费者
 *
 * @author DB
 * @create 2020-10-08 15:42
 */
@Service
@RocketMQMessageListener(topic = "article_system_topic",consumerGroup = "article_system_consumer")
public class Consumer implements RocketMQListener<String> {
	@Override
	public void onMessage(String message) {
		System.out.println(message);
	}
}
