package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Setter(onMethod_ = { @Autowired })
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		// restaurant 변수가 null이 아니어야만 테스트가 성공
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("------------------------------");
		log.info(restaurant.getChef());
	}
}
