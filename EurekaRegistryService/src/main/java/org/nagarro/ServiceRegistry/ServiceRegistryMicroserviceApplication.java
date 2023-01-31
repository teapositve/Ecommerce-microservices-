package org.nagarro.ServiceRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistryMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistryMicroserviceApplication.class, args);
	}

}
