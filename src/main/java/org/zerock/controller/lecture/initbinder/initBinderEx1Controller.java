package org.zerock.controller.lecture.initbinder;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/init1")
@Log4j
public class initBinderEx1Controller {

	@Data
	public static class MyData{
		private String name;
		private int age;
	}
	
	public static class MyDataEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			//text ==> name-age
			String[] data = text.split("-");
			String name = data[0];
			int age = Integer.valueOf(data[1]);
			
			MyData d = new MyData();
			d.setName(name);
			d.setAge(age);
			
			setValue(d);
		}
		
	}
	
	
	@RequestMapping("/ex1")
	public void method1(String name) {
		log.info("method1");
		log.info(name);
	}
	
	@RequestMapping("/ex2")
	public void method2(@RequestParam MyData data) {
		log.info("method2");
		log.info(data);
	}
	
	@RequestMapping("/ex3")
	public void method3(@RequestParam Date birth) {
		log.info("method3");
		log.info(birth);
	}
	
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		log.info("inint binder");
//		
//		binder.registerCustomEditor(MyData.class, new MyDataEditor());
//		
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//	}
}
