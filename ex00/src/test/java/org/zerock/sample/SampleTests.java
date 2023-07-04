package org.zerock.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;

//테스트환경

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
//@Log4j
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Autowired
	private SampleHotel hotel;
	
	@Test
	public void testExist() {
		
//		log.info(restaurant); //@Log4j 쓸때
		log.info("restaurant : {}", restaurant);
		log.info("restaurant : {}", restaurant.getChef());
	}
	
	@Test
	public void testHotel() {
		log.info("hotel : {}", hotel.getChef());
	}
	
	
	
	
	
	
	
	
	
	
	

}
