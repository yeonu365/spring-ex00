package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("bag")
@Component
public class Bag {
	private Book book; //가방이 book 을 dependency로 가지고 있다.
	
	public Bag() {
		
	}
	
	@Autowired
	public Bag(Book book) {
		this.book = book;
	}
	
	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}
	
//	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
// @Autowired 로 자동 주입
}
