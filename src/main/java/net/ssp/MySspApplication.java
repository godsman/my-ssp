package net.ssp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MySspApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySspApplication.class, args);
	}
}
