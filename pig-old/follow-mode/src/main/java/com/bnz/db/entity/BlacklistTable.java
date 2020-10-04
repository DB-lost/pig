package com.bnz.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class BlacklistTable implements Serializable {
	@TableId(type = IdType.AUTO)
	private String id;
	private String blacklistId;
	private String userId;
	private Byte isBlack;
}
