package com.bnz.db.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-10-09 11:18
 */
@Configuration
public class WebSocket {
	/**
	 * ServerEndpointExporter 作用
	 *
	 * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
	 *
	 * @return
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
