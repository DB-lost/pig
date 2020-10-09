package com.bnz.db.controller;

import com.bnz.db.service.FollowService;
import com.pig4cloud.pig.common.core.util.R;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

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
	@Autowired
	private RocketMQTemplate rocketMQTemplate;

	/**
	 * 查询关注或粉丝
	 *
	 * @param userId
	 * @param type
	 * @return
	 */
	@GetMapping("/selectFollow")
	public R selectFollow(String userId, String type) {
		R r = followService.selectFollow(userId, type);
		return r.setCode(20000);
	}

	@GetMapping("/insertFollow")
	public R insertFollow(String userId, String followId) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("userId",userId);
		map.put("followId",followId);
		rocketMQTemplate.convertAndSend("article_system_topic",map);
		R r = followService.insertFollow(userId, followId);
		return r.setCode(20000);
	}

	@DeleteMapping("/deleteFollow")
	public R deleteFollow(String userId, String followId) {
		rocketMQTemplate.convertAndSend("article_system_topic","取消关注");
		R r = followService.deleteFollow(userId, followId);
		return r.setCode(20000);
	}

	@GetMapping("/selectBlacklist")
	public R selectBlacklist(String userId) {
		R r = followService.selectBlacklist(userId);
		return r.setCode(20000);
	}

	@GetMapping("/insertBlacklist")
	public R insertBlacklist(String userId, String blacklistId) {
		rocketMQTemplate.convertAndSend("article_system_topic","放入黑名单");
		R r = followService.insertBlacklist(userId, blacklistId);
		return r.setCode(20000);

	}

	@DeleteMapping("/deleteBlacklist")
	public R deleteBlacklist(String userId, String blacklistId) {
		rocketMQTemplate.convertAndSend("article_system_topic","取出黑名单");
		R r = followService.deleteBlacklist(userId, blacklistId);
		return r.setCode(20000);
	}

	/**
	 * WebSocket:单体应用中会用到，前后端分离中不需要
	 * @return
	 */
//	@RequestMapping("/index")
//	public String index() {
//		return "index";
//	}

	@GetMapping("/webSocket")
	public ModelAndView socket() {
		ModelAndView mav=new ModelAndView("/webSocket");
//        mav.addObject("userId", userId);
		return mav;
	}
}
