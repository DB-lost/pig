package com.bnz.db.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class FansTable implements Serializable {
	@TableId(type = IdType.AUTO)
	private String id;
	private String userId;
	private String fansId;
}
