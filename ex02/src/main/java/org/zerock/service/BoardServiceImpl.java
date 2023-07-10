package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;


@Service //@conponent 와 같다
@Slf4j
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	
	//자동주입
	private final BoardMapper mapper;
	
	@Override
	public void register(BoardVO vo) {
		log.info("regiset : {}" , vo);
		mapper.insertSelectKey(vo);
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("get : {}", bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO vo) {
		log.info("modify : {}" , vo);
		return mapper.update(vo)==1 ? true : false;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove : {}" , bno);
		return mapper.delete(bno)==1 ? true : false;
	}

	@Override
	public List<BoardVO> getlist() {
		log.info("getList");
		return mapper.getList();
	}
	
	
	

}
