package org.zerock.mapper;


import java.util.List;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Criterial;
import org.zerock.domain.ReplyVO;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class ReplyMapperTests {

	@Autowired
	private ReplyMapper replyMapper;
	
	private Long[] bnoArr = {1000L, 1001L, 1002L, 1003L, 1004L};
	
	@Test
	public void testMapper() {
		log.info("replyMapper : {}", replyMapper);
	}
	
	
	@Test
	public void testInsert() {
		IntStream.rangeClosed(1, 10).forEach(i->{
			ReplyVO vo = new ReplyVO();
			
			vo.setBno(bnoArr[i%5]);
			vo.setReply("댓글 테스트" + i);
			vo.setReplyer("user0" + i);
			
			replyMapper.insert(vo);
		});
	}
	
	@Test
	public void testRead() {
		ReplyVO vo = replyMapper.read(5L);
		log.info("vo ==> {}", vo);
	}
	
	@Test
	public void testDelete() {
		int result = replyMapper.delete(5L);
		log.info("result ==> {}", result);
	}
	
	@Test
	public void testUpdate() {
		ReplyVO vo = new ReplyVO();
		vo.setRno(10L);
		vo.setReply("ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ");
		
		int result = replyMapper.update(vo);
		log.info("result ==> {}", result);
	}
	
	@Test
	public void testGetListWithPaging() {
//		List<ReplyVO> list = replyMapper.getListWithPaging(new Criterial(), 1000L);
//		replyMapper.getListWithPaging(new Criterial(), 1000L)
		replyMapper.getListWithPaging(new Criterial(2,10), 1000L) //2page 10개
			.forEach(n->{
				log.info("list => {}", n);
		});
	}
	


	
	
	


}

