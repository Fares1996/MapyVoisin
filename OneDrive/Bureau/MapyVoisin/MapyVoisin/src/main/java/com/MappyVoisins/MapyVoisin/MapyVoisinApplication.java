package com.MappyVoisins.MapyVoisin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
class MapyVoisinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapyVoisinApplication.class, args);
	}

}
