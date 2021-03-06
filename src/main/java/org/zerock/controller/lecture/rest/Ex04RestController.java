package org.zerock.controller.lecture.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest04")
public class Ex04RestController {

	// /rest04/sub01?bno=3
	// /rest04/sub01/3
	@RequestMapping("/sub01/{num}")
	public String method01(@PathVariable("num") String num) {
							// num 생략 가능
		return num;
	}
	
	@RequestMapping("/sub02/{var1}/sub02/{var2}")
	public String method02(@PathVariable String var1, @PathVariable String var2) {
		
		return var1 + ", " + var2;
	}
}
