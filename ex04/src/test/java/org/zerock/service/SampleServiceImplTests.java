package org.zerock.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@Slf4j
public class SampleServiceImplTests {

	@Autowired
	private SampleService service;

	@Test
	public void test() {

		log.info("service : {}", service);
		log.info("service.getClass : {}", service.getClass().getName());
		
	}
	
	@Test
	public void testAdd() throws Exception {
		log.info("add : {}", service.doAdd("123", "333"));
	}
	
	@Test
	public void testMul() throws Exception{
		log.info("mul : {}", service.doMul("123", "333"));
	}

	@Test
	public void testException() throws Exception{
		log.info("Add : {}", service.doAdd("123", "111"));
	}


	
	
	
	
	
	

}
