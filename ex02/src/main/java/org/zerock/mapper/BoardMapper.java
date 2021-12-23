package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
	
	// XML에 SQL문이 처리되었기 때문에 select문을 주석처리함
	// @Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();
	
	// insert만 처리되고 생성된 PK 값을 알 필요가 없는 경우
	public void insert(BoardVO board);
	
	// insert문이 실행되고 생성된 PK 값을 알아야 하는 경우
	public void insertSelectKey(BoardVO board);
	
	// 존재하는 게시물 번호로 테스트
	public BoardVO read(Long bno);
	
	public int delete(Long bno);
	
	// 몇 개의 데이터가 수정되었는가를 처리할 수 있도록 int형으로 선언
	public int update(BoardVO board);
}
