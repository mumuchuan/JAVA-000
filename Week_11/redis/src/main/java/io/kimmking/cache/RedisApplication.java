package io.kimmking.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.kimmking.cache")
public class RedisApplication {

	public static void main(String[] args) {

		SpringApplication.run(RedisApplication.class, args);
	}

}
