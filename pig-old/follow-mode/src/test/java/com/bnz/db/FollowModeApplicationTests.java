package com.bnz.db;

import com.bnz.db.service.FollowService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FollowModeApplicationTests {
	@Autowired
	private FollowService followService;


	@Test
	void SelectFollow(){
		followService.selectFollow("3","follow");
	}

}
