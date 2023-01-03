package com.sparc.remo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Remo2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(Remo2Application.class, args);
	}

}
