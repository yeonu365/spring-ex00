package org.zerock.sample;

import lombok.ToString;

import org.springframework.stereotype.Component;

import lombok.Getter;

// root-context.xml 에 설명서를 넣었다. 
// 어디에서 찾으라고 base-package="" 를 통해 알려줌.
@Component
@ToString
@Getter
public class SampleHotel {
	private Chef chef;
	
	
	public SampleHotel(Chef chef) {
		this.chef = chef;
	}
}
