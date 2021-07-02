package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	// 추상 메소드를 구현해야한다. override
	
	private BoardMapper mapper;
	//DI 받으려면 set() 또는 생성자가 있으면 된다.
	private ReplyMapper replyMapper;
	
//	@Autowired
//	public BoardServiceImpl(BoardMapper mapper) {
//		this.mapper = mapper;
//	}   <-- [lombok] @allargsconstructor 로 대신한다.
	
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		return mapper.update(board) == 1;
	}

	@Override
	@Transactional
	public boolean remove(Long bno) {
		// 댓글 삭제
		replyMapper.deleteByBno(bno);
		
		// 게시물 삭제
		int cnt = mapper.delete(bno);
		return cnt == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		// Criteria 추가에 따라 parameter 추가 및 변경
		return mapper.getListWithPaging(cri);
	}
	
	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
	

}
