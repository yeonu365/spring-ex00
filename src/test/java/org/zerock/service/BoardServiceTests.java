package org.zerock.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;
	
	@Test
	public void testExist() {
		assertNotNull(service);
	}
	
	@Test
	public void testRegister() {
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글2");
		board.setContent("새로 작성하는 내용2");
		board.setWriter("newbie");
		
		service.register(board);
		assertNotEquals(0, board.getBno());;
	}
	
	@Test
	public void testGetList() {
		List<BoardVO> list = service.getList();
		
		assertNotNull(list);
		assertTrue(list.size()>0);
	}
	
	@Test
	public void testGet() {
		BoardVO vo = service.get(1L);
		
		assertEquals(1, vo.getBno());
	}
	
	@Test
	public void testModify() {
		BoardVO vo = service.get(1L);
		vo.setTitle("수정된 제목");
		vo.setContent("수정된 본문");
		service.modify(vo);
		
		vo = service.get(1L);
		
		assertEquals("수정된 제목",	vo.getTitle());
		assertEquals("수정된 본문", vo.getContent());
	}
	
	@Test
	public void testRemove() {
		Long key1 = 13L;
//		Long key2 = 14L;
		
		assertFalse(service.remove(key1));
//		assertTrue(service.remove(key2));
		
		// 입력 후 삭제
		BoardVO vo = new BoardVO();
		vo.setTitle("title");
		vo.setContent("content");
		vo.setWriter("writer");

		service.register(vo);
		assertTrue(service.remove(vo.getBno()));
	}
}
