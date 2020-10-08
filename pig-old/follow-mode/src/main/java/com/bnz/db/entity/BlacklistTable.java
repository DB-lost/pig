package com.bnz.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DESC: 黑名单
 *
 * @author DB
 * @create 2020-09-30 9:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("黑名单")
public class BlacklistTable implements Serializable {
	@TableId(type = IdType.AUTO)
	private String id;
	@ApiModelProperty("黑名单用户id")
	private String blacklistId;
	@ApiModelProperty("用户id")
	private String userId;
	private Byte isBlack;
}
