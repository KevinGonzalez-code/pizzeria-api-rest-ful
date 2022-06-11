package com.kevin.pizzeria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PizzeriaApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(PizzeriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		System.out.println("---------------------------------");
		// System.out.println(passwordEncoder.encode("kevin"));
	}

}
