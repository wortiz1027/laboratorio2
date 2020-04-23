package co.edu.javeriana.securityserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SecurityserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityserverApplication.class, args);
	}

}