package org.zerock.mapper;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;

//DB에 있는 list 가져오기	
	@Test
	public void testGetlist() {
		//방법1
//		List<BoardVO> list = boardMapper.getList();
//		for(BoardVO vo : list)
//			log.info("vo : {}", vo);
		
		//방법2
		boardMapper.getList().forEach((vo)->{
			log.info("vo : {}", vo);
		});
	}
	
//삽입	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("java");
		vo.setContent("빡시게 자바 공부중");
		vo.setWriter("남궁성");
		
		int result = boardMapper.insert(vo);
		
		log.info("result : {}", result);
	}
	
//수정
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(6L);
		vo.setTitle("Spring");
		vo.setContent("멍때리는 중");
		vo.setWriter("이성진");
		
		int result = boardMapper.update(vo);
		
		log.info("result : {}", result);
	}

//DB 데이터 1건 읽어오기
	@Test
	public void testRead() {
		
		BoardVO vo = boardMapper.read(4L);
		log.info("vo : {}", vo);
	}
//insert할 때 bno 번호를 console 에서 알고싶을 때
	@Test
	public void testInsertSelectKey() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("React2");
		vo.setContent("리액트 공부중");
		vo.setWriter("조조2");
		
		int result = boardMapper.insertSelectKey(vo);
		
		log.info("result : {}", result);
	}
	
//삭제
	@Test
	public void delete() {
		BoardVO vo = new BoardVO();
		
		int result = boardMapper.delete(10L);
		log.info("result : {}", result);
		
	}
	
	@Test
	public void insert2() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("java");
		vo.setContent("핸드폰하는중");
		vo.setWriter("노예은");
		
		int result = boardMapper.insert2(vo);
		
		log.info("result : {}", result);
		
	}
	
	
	@Test
	public void update2() {
		BoardVO vo = new BoardVO();
		
		vo.setBno(12L);
		vo.setTitle("Spring");
		vo.setContent("공부하는중");
		vo.setWriter("서연주");
		
		int result = boardMapper.update2(vo);
		log.info("result : {}", result);
	}
	
	@Test
	public void testPaging() {
		Criterial cri = new Criterial(3,10);
		
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(vo -> log.info("vo : {}", vo));
	}

	
	
	
	
	
	
	
}
