package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	
	public  void register(BoardVO vo);
//데이터 가져오기	
	public BoardVO get(Long bno);
//데이터 수정	
	public boolean modify(BoardVO vo);
//데이터 삭제
	public boolean remove(Long bno);
//데이터 리스트로 가져오기	
	public List<BoardVO> getlist();

}
