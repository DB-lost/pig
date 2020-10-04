package com.bnz.db.controller;

import com.bnz.db.service.FollowService;
import com.pig4cloud.pig.common.core.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC:
 *
 * @author DB
 * @create 2020-09-30 10:52
 */
@RestController
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	private FollowService followService;

	@GetMapping("/selectFollow")
	public R selectFollow(String userId, String type) {
		R r = followService.selectFollow(userId, type);
		return r;
	}
}
