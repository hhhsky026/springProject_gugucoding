package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service // 비즈니스 영역을 담당하는 객체임을 표시
@RequiredArgsConstructor // AllArgsConstructor보다 Required를 쓰는게 private final로 변수를 만들어서, 불필요한 생성자를 만들지 않기 때문에 좋아!
public class BoardServiceImpl implements BoardService {
	
	//@Setter(onMethod_ = @Autowired) 순환참조가 발생할 가능성이 있기 때문에 ArgsConstructor을 쓰는게 좋아
	@NonNull
	private final BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		log.info("register......" + board);
		
		mapper.insertSelectKey(board);
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get........."+ bno);
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify......" + board);
		
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove......" + bno);
		
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		log.info("getList.......");
		
		return mapper.getList();
	}
}
