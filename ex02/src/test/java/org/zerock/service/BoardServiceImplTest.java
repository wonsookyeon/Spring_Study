package org.zerock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class BoardServiceImplTest {
	
	@Autowired
	private BoardService service;

	@Test
	public void testGetList() {
		log.info("------------------GetList");
		
		service.getlist().forEach(
				(list)->{
					log.info("list : {}", list);
				});
	}
	
	@Test
	public void testRemove() {
		log.info("------------------testRemove");
		service.remove(4L);
	}
	
	@Test
	public void testModify() {
		log.info("------------------testModify");
		
		BoardVO vo = new BoardVO();
		
		vo.setTitle("JSP");
		vo.setContent("공부하는 척 중");
		vo.setWriter("정혜민");
		vo.setBno(3L);
		
//		service.modify(vo);
		log.info("modify : {}", service.modify(vo));
	}
	
	@Test
	public void testGet() {
		log.info("------------------testGet");
		
		BoardVO vo = service.get(3L);
		log.info("vo : {}", vo);
		
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		
		vo.setTitle("java2");
		vo.setContent("공부하는중");
		vo.setWriter("노예은");
		
		service.register(vo);
		
		log.info("result : {}" , vo);
		
	}

	
	
	
}
