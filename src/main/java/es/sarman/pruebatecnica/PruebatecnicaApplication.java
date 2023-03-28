package es.sarman.pruebatecnica;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PruebatecnicaApplication {

	@Value("${greet}")
	public String greet;

	public static void main(String[] args) {
		SpringApplication.run(PruebatecnicaApplication.class, args);
	}

	@GetMapping("/greet")
	public String greet() {
		return greet;
	}

}
