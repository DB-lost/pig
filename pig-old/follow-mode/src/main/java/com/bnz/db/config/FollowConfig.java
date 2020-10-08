package com.bnz.db.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-09-30 10:36
 */
@Configuration
@MapperScan("com.bnz.db.mapper")
@EnableSwagger2
@EnableWebSocket
public class FollowConfig  {
	//配置文档信息
	private ApiInfo apiInfo() {
		Contact contact = new Contact("DB", "http://bnz.cn", "2502523450@qq.com");
		return new ApiInfo("关注模块",
			"关注模块API的测试",
			"1.0",
			"https://www.baidu.com",
			contact, //联系人信息
			"许可",
			"许可连接",
			new ArrayList<VendorExtension>());//扩展
	}

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
