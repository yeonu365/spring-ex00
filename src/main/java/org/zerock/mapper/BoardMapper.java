package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

//	@Select("SELECT * FROM tbl_board")  쿼리가 길어질수 있어서, boardMapper.xml 파일 생성
	public List<BoardVO> getList();
	
	/* INSERT INTO tbl-board (title, content, writer) 
	 VALUES (#{title}, #{content}, #
	myBatis 에서 확용하는 쿼리
	이 쿼리들을 boardMapper.xml 파일에 따로 빼주기로 했다.
	*/
	
	public List<BoardVO> getListWithPaging(Criteria cri);
	
	public int insert(BoardVO board);
	/*
	 	String sql = "INSERT INTO tbl_board(title, content, writer) VALUES (?,?,?)";
	 	PrepareStatement pstmt ....
	 	pstmt.setString(1, board.getTitle());
	 	pstmt.setString(2, board.getContent());
	 	pstmt.setString(3, board.getWriter());
	 	
	 	pstmt.executeUpdate();
	 이 작없들을 myBatis 가 해준다.
	 */
	
	public int insertSelectKey(BoardVO board);
	
	// key 값을 받아서 하나의 record 만 얻어오게 한다.
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);

	public int getTotalCount(Criteria cri);
	
}

