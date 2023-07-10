package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Slf4j
@WebAppConfiguration
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		
		log.info("{}",                               // post 방식이면 post로 바꿔줌
				mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
				.andReturn()
				.getModelAndView() //
				.getModelMap() //결과정보를 담아서 옴
				);
	}
	
	
	@Test
	public void testRegister() throws Exception {
		
		log.info("{}",                               // post 방식이면 post로 바꿔줌
				mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
					.param("title", "오라클")
					.param("content", "view 공부중")
					.param("writer", "이지스퍼블리싱")
					)
				.andReturn()
				.getModelAndView()
				.getViewName() //반환되는 값이 없으면
				);
	}
	
	@Test
	public void testGet() throws Exception {
		
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.get("/board/get")
						.param("bno", "15")
						)
				.andReturn()
				.getModelAndView() //
				.getModelMap() //반환되는 값이 있으면
				);
	}
	
	@Test
	public void testRemove() throws Exception {
		
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
						.param("bno", "14")
						)
				.andReturn()
				.getModelAndView() //
				.getViewName() //반환되는 값이 없으면
				);
	}
	
	@Test
	public void testModify() throws Exception {
		
		log.info("{}",
				mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
						.param("bno", "2")
						.param("title", "STS")
						.param("content", "Spring공부중")
						.param("writer", "ㅇㅅㅇ")
						)
				.andReturn()
				.getModelAndView() //
				.getViewName() //반환되는 값이 없으면
				);
	}
	
	
	
	
	
	

}
