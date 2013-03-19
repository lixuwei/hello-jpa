package com.lee.study.hellojpa;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
   
	@Test
	public void testDB(){
		new ClassPathXmlApplicationContext("spring.xml");
	}
	
}
