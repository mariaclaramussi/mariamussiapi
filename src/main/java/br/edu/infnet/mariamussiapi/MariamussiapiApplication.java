package br.edu.infnet.mariamussiapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MariamussiapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MariamussiapiApplication.class, args);
	}

}
