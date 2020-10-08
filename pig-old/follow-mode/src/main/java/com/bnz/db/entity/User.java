package com.bnz.db.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * DESC:  用户表
 *
 * @author DB
 * @create 2020-09-30 9:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户")
public class User implements Serializable {
	@TableId(type = IdType.AUTO)
	private String id ;  //
	private String username;  //用户姓名
	private String password;  //用户密码
	private Byte isDeleted;  //0-未删除，1-已删除
	private Byte isBanned;  //0-未禁用，1-已禁用
	@TableField(fill = FieldFill.INSERT)  //自动注入
	private Date createdTime;  //用户注册时间
	@TableField(fill = FieldFill.INSERT_UPDATE)  //自动注入
	private Date updatedTime;  //用户个人信息修改时间
	private String birthday;  //用户的生日
	private String email;  //用户邮箱
	private String avatar;  //用户的个人头像
	private Byte sex;  //0-男，1-女
	private String phone;  //用户手机号码
	private String IdCard;  //用户身份证号
	private String introduce;  //用户简介
}
