package com.bnz.db;

import com.bnz.db.service.FollowService;
import com.pig4cloud.pig.common.core.util.R;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FollowModeApplicationTests {
	@Autowired
	private FollowService followService;


	@Test
	void SelectFollow() {
		followService.selectFollow("3", "follow");
	}

	@Test
	void InsertFollow() {
		R r = followService.insertFollow("1", "2");
		System.out.println(r);
	}

	@Test
	void DeleteFollow(){
		followService.deleteFollow("4","1");
	}

	@Test
	void InsertBlacklist(){
		followService.insertBlacklist("1","2");
	}

	@Test
	void SelectBlacklist(){
		followService.selectBlacklist("1");
	}

	@Test
	void DeleteBlacklist(){
		followService.deleteBlacklist("1","2");
	}
}
