package com.bnz.db.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * DESC:   自动注入
 *
 * @author DB
 * @create 2020-09-30 10:37
 */
@Component
public class FollowHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createdTime", new Date(), metaObject);
		this.setFieldValByName("updatedTime", new Date(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("updateTime", new Date(), metaObject);
	}
}
