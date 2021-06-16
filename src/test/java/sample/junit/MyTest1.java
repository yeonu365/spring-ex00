package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test
	public void test() {
//		fail("Not yet implemented");   <-- 무조건 실패하는 ()
		int i = 3;
		if (i != 3) {
			fail("i는 3이 아닙니다.");
		}
	}
	
	@Test
	public void equals() {
		int i =3;
		boolean b = true;
		Object c = null;
		
		assertEquals(i, 3);  //i 가 3이면 성공
		assertEquals(b, true);
		assertTrue(b);
		assertNull(c);
	}
	
	@Test
	public void notEquals() {
		int i=5;
		boolean b = false;
		Object c = new Object();
		assertNotEquals(i, 3); //i가 3이 아.니.면. 성공
		assertNotEquals(b, true);
		assertFalse(b);
		assertNotNull(c);
	}
}
