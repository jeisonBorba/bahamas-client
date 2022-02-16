package com.br.jborba.bahamasclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = "com.br.jborba.bahamasclient")
@EnableFeignClients
public class BahamasClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BahamasClientApplication.class, args);
	}

}
