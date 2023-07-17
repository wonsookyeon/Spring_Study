package org.zerock.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardMapperTests {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    public void testGetList() {
//        List<BoardVO> list = boardMapper.getlist();
//        for(BoardVO vo : list)
//            log.info("vo : {}",vo);
        boardMapper.getlist().forEach((vo)-> {
            log.info("vo : {}",vo);
        });
    }

    @Test
    public void testRead(){
        BoardVO vo = boardMapper.read(3L);
        log.info("vo : {} : {}",vo.getTitle(),vo.getContent());

    }

    @Test
    public void testInsert(){
        BoardVO vo = new BoardVO();
        vo.setTitle("java");
        vo.setContent("자바 공부 종나게 하는중");
        vo.setWriter("박종진");

        int result = boardMapper.insert(vo);

        log.info("result : {}",result);
    }

    @Test
    public void testInsertSelectKey(){
        BoardVO vo = new BoardVO();
        vo.setTitle("React");
        vo.setContent("React 공부 종나게 하는중");
        vo.setWriter("박종진");

        int result = boardMapper.insertSelectKey(vo);

        log.info("result : {}",result);
    }


    @Test
    public void testUpdate(){
        BoardVO vo = new BoardVO();
        vo.setBno(3L);
        vo.setTitle("python");
        vo.setContent("파이썬 공부 종나게 하는중");
        vo.setWriter("Park Jong Jin");

        int result = boardMapper.update(vo);

        log.info("result : {}",result);
    }

    @Test
    public void testDelete(){
        Long bno = 4L;

        int result = boardMapper.delete(bno);

        log.info("result : {}",result);
    }

    @Test
    public void selfInsertTest(){
        BoardVO vo = new BoardVO();

        vo.setTitle("내가 작성한 코드");
        vo.setContent("vo.setContent");
        vo.setWriter("박종진");


        int result = boardMapper.insertTest(vo);

        log.info("result : {}", result);
    }

    @Test
    public void selfUpdateTest() {
        BoardVO vo = new BoardVO();

        vo.setTitle("내가 작성한 코드(수정본)");
        vo.setContent("vo.setContent(수정본)");
        vo.setWriter("박종진 (수정본)");
        vo.setBno(10L);

        int result = boardMapper.updateTest(vo);

        log.info("result : {}",result);
    }

    @Test
    public void selfGetListTest() {
        List<BoardVO> list = boardMapper.getListTest();
        for(BoardVO vo : list){
            log.info("vo : {}", vo);
        }

    }

    @Test
    public void testPaging() {
        Criterial cri = new Criterial(2,10);

        List<BoardVO> list = boardMapper.getListWithPaging(cri);
        list.forEach(vo-> log.info("vo: {}", vo));
    }
    
    @Test
    public void testSearchTest() {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	
    	map.put("T", "Spring"); //Title
    	map.put("C", "멍때리는 중"); //Content
    	map.put("W", "원숙연"); //Writer
    	
    	
    	Map<String, Map<String, String>> outer = new HashMap();
    	outer.put("map", map);
    	
    	List<BoardVO> list = boardMapper.searchTest(outer);
    	log.info("list: {}", list);
    }
    
    @Test
    public void testSearchPaging() {
    	Criterial cri = new Criterial();
    	cri.setType("TCW");
    	cri.setKeyword("Spring");
    	List<BoardVO> list = boardMapper.getListWithPaging(cri);
    	
    	log.info("list : {}", list);
    	
    }
    
    @Test
    public void testGetTotalCount() {
    	Criterial cri = new Criterial();
    	cri.setType("CWT");
    	cri.setKeyword("Spring");
    	int count = boardMapper.getTotalCount(cri);
    	
    	log.info("count : {}", count);
    	
    }
    
    
    

}
