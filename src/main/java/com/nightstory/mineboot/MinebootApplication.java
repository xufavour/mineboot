package com.nightstory.mineboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author 006
 */
@EnableScheduling
@SpringBootApplication
@EnableAsync
public class MinebootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MinebootApplication.class, args);
//		Student testBean  = (Student) context.getBean("testBean");
//		System.out.println(testBean);
//		Student testBean2  = (Student) context.getBean("testBean");
//		System.out.println(testBean2);
	}
}
