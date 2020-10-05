package com.bnz.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnz.db.entity.BlacklistTable;
import com.bnz.db.entity.FansTable;
import com.bnz.db.entity.User;
import com.bnz.db.mapper.BlacklistTableMapper;
import com.bnz.db.mapper.FansTableMapper;
import com.bnz.db.mapper.UserMapper;
import com.bnz.db.service.FollowService;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-09-30 10:49
 */
@Service
public class FollowServiceImpl implements FollowService {
	@Autowired
	private FansTableMapper fansTableMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private BlacklistTableMapper blacklistTableMapper;


	/**
	 * 查询关注列表
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public R selectFollow(String userId, String type) {
		if (StringUtils.isEmpty(userId)) {
			return R.failed("服务器正忙，请稍后再试!");
		} else {
			//获取粉丝表
			ArrayList<User> users = new ArrayList<>();
			QueryWrapper<FansTable> queryWrapper = new QueryWrapper<>();
			//前端传输标识(如果是follow，查询关注列表，否则查询粉丝列表)
			if (type.equals("follow")) {
				queryWrapper.eq("fans_id", userId);
				List<FansTable> fansTables = fansTableMapper.selectList(queryWrapper);
				for (FansTable fans : fansTables) {
					User user = userMapper.selectById(fans.getUserId());
					System.out.println(user);
					users.add(user);
				}
			} else {
				queryWrapper.eq("user_id", userId);
				List<FansTable> fansTables = fansTableMapper.selectList(queryWrapper);
				for (FansTable fans : fansTables) {
					User user = userMapper.selectById(fans.getFansId());
					System.out.println(user);
					users.add(user);
				}
			}
			return R.ok(users);
		}
	}

	/**
	 * 插入新的关注
	 *
	 * @param userId
	 * @param followId
	 * @return
	 */
	@Override
	public R insertFollow(String userId, String followId) {
//		//先查询，如果存在就更新，否则插入
//		QueryWrapper<FansTable> queryWrapper = new QueryWrapper<>();
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("user_id", followId);
//		map.put("fans_id", userId);
//		queryWrapper.allEq(map);
//		FansTable one = fansTableMapper.selectOne(queryWrapper);
//		System.out.println(one);
		//如果查询结果为空插入
//		if (StringUtils.isEmpty(one)) {
		FansTable fansTable = new FansTable();
		//将关注的用户设置成用户id
		fansTable.setUserId(followId);
		//将用户自己设置成粉丝id
		fansTable.setFansId(userId);
		fansTableMapper.insert(fansTable);
		return R.ok("success");
//		} else {  //更新
//			return R.ok().setMsg("请不要重复插入！");
//		}
		//同时插入到MongoDB中
	}

	/**
	 * 删除关注
	 *
	 * @param userId
	 * @param followId
	 * @return
	 */
	@Override
	public R deleteFollow(String userId, String followId) {
		QueryWrapper<FansTable> queryWrapper = new QueryWrapper<>();
		HashMap<String, Object> map = new HashMap<>();
		//根据用户和关注的id找出数据并删除
		map.put("user_id", followId);
		map.put("fans_id", userId);
		queryWrapper.allEq(map);
		fansTableMapper.delete(queryWrapper);
		return R.ok("删除成功!");
	}

	/**
	 * 查询黑名单
	 *
	 * @param userId
	 * @return
	 */
	@Override
	public R selectBlacklist(String userId) {
		if (StringUtils.isEmpty(userId)) {
			return R.failed("服务器正忙，请稍后再试!");
		} else {
			ArrayList<User> users = new ArrayList<>();
			QueryWrapper<BlacklistTable> queryWrapper = new QueryWrapper<>();
			queryWrapper.eq("user_id", userId);
			List<BlacklistTable> tables = blacklistTableMapper.selectList(queryWrapper);
			for (BlacklistTable table : tables) {
				User user = userMapper.selectById(table.getBlacklistId());
				users.add(user);
			}
			System.out.println(users);
			return R.ok(users);
		}
	}

	/**
	 * 插入黑名单
	 *
	 * @param userId
	 * @param blacklistId
	 * @return
	 */
	@Override
	public R insertBlacklist(String userId, String blacklistId) {
		BlacklistTable blacklistTable = new BlacklistTable();
		blacklistTable.setUserId(userId);
		blacklistTable.setBlacklistId(blacklistId);
		blacklistTable.setIsBlack(new Byte("1"));
		blacklistTableMapper.insert(blacklistTable);
		return R.ok("添加成功");
	}

	@Override
	public R deleteBlacklist(String userId, String blacklistId) {
		QueryWrapper<BlacklistTable> queryWrapper = new QueryWrapper<>();
		HashMap<String, Object> map = new HashMap<>();
		map.put("user_id",userId);
		map.put("blacklist_id",blacklistId);
		queryWrapper.allEq(map);
		blacklistTableMapper.delete(queryWrapper);
		return R.ok("删除成功!");
	}
}
