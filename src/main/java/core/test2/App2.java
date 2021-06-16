package core.test2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class App2 {
	public static void main(String[] args) {
		System.out.println("프로그램 실행2");
		
		String path="core/test2/core-test2.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
//		component 를 통해 SpringBean 을 만든다.
//		.xml에서 @Component("이름") 을 지정하여 method("이름")으로 사용한다.
		Object o1 = context.getBean("bag");
		Object o2 = context.getBean("book");
		
		System.out.println(o1);
		System.out.println(o2);
	}
}
