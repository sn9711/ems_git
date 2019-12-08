package com.sn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.sn.dao")
public class EmsGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsGitApplication.class, args);
	}

}
