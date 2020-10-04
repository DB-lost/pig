package com.bnz.db.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-09-30 10:36
 */
@Configuration
@MapperScan("com.bnz.db.mapper")
public class FollowConfig {
//	/**
//	 * 分页插件  在引入的mybatis——plus中有定义
//	 */
//	@Bean("followPaginationInterceptor")
//	public PaginationInterceptor paginationInterceptor() {
//		return new PaginationInterceptor();
//	}
}
