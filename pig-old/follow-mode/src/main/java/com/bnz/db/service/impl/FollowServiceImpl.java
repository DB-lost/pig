package com.bnz.db.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bnz.db.entity.FansTable;
import com.bnz.db.entity.User;
import com.bnz.db.mapper.FansTableMapper;
import com.bnz.db.mapper.UserMapper;
import com.bnz.db.service.FollowService;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
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

	@Override
	public R InsertFollow(String userId, String followId) {
		System.out.println("hello_world");
		return null;
	}

	@Override
	public R deleteFollow(String userId, String followId) {
		return null;
	}

	@Override
	public R selectBlacklist(String userId) {

		return null;
	}

	@Override
	public R InsertBlacklist(String userId, String blacklistId) {
		return null;
	}

	@Override
	public R DeleteFollow(String userId, String blacklistId) {
		return null;
	}
}
