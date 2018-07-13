package com.hesen.share.facade.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hesen.share"})
public class ShareFacadeimplApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShareFacadeimplApplication.class, args);
	}
}
