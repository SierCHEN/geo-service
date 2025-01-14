package com.cse.geo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.cse.geo.infrastructure.repositories.*")
@SpringBootApplication
public class GeoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoServiceApplication.class, args);
	}

}
