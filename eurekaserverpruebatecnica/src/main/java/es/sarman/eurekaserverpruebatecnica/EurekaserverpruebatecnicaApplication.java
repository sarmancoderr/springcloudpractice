package es.sarman.eurekaserverpruebatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverpruebatecnicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaserverpruebatecnicaApplication.class, args);
	}

}
