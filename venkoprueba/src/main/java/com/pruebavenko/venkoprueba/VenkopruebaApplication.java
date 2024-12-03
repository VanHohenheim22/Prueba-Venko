package com.pruebavenko.venkoprueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.pruebavenko")
public class VenkopruebaApplication {

	public static void main(String[] args) {
		SpringApplication.run(VenkopruebaApplication.class, args);
	}

}
