 package com.lti.paysmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lti.paysmart")
@EntityScan("com.lti.paysmart")
public class PaySmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaySmartApplication.class, args);
	}

}
