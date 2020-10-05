package com.bnz.db.service;

import com.pig4cloud.pig.common.core.util.R;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-09-30 10:45
 */
public interface FollowService {

	public R selectFollow(String userId,String type);

	public R insertFollow(String userId, String followId);

	public R deleteFollow(String userId, String followId);

	public R selectBlacklist(String userId);

	public R insertBlacklist(String userId, String blacklistId);

	public R deleteBlacklist(String userId, String blacklistId);
}
