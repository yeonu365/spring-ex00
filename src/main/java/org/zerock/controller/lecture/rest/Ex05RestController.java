package org.zerock.controller.lecture.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest05")
@Log4j
public class Ex05RestController {

	@RequestMapping("/sub01")
	public User method01(@RequestBody User user) {
		//JSON 데이터가 들어오면 User(객체)로 자동 converting
		log.info("rest05 sub01 method....");
		return user;
	}
}
