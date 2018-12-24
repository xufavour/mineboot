package com.nightstory.mineboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		SpringApplication.run(MinebootApplication.class, args);
	}
}
