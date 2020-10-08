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
 * DESC:  粉丝表
 *
 * @author DB
 * @create 2020-09-30 9:32
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("粉丝表")
public class FansTable implements Serializable {
	@TableId(type = IdType.AUTO)
	private String id;
	@ApiModelProperty("用户id")
	private String userId;
	@ApiModelProperty("粉丝id")
	private String fansId;
}
