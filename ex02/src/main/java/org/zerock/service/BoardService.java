package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	
	// 등록
	public void register(BoardVO board);
	
	// 특정한 게시물을 가져오기 때문에 리턴 타입 결정해서 진행 가능
	// 조회
	public BoardVO get(Long bno);
	
	// 수정
	public boolean modify(BoardVO board);
	
	// 삭제
	public boolean remove(Long bno);
	
	// 전체 리스트를 구하기 때문에 리턴 타입 결정해서 진행 가능
	// 리스트 가져오기
	public List<BoardVO> getList();
}
