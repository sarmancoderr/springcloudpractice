package es.sarman.eurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaconsumerApplication.class, args);
	}

}
