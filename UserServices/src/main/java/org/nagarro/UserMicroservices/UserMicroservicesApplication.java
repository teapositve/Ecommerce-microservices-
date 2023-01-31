package org.nagarro.UserMicroservices;

import org.nagarro.UserMicroservices.constant.AppConstant;
import org.nagarro.UserMicroservices.dao.RoleRepo;
import org.nagarro.UserMicroservices.models.Role;
import org.nagarro.UserMicroservices.utils.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class UserMicroservicesApplication implements CommandLineRunner {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(UserMicroservicesApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void run(String... args) throws Exception {

//		System.out.println(this.passwordEncoder.encode ("123"));


		try {

			Role role = new Role();
			role.setId(AppConstant.ROLE_ADMIN);
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstant.ROLE_NORMAL);
			role1.setName("ROLE_NORMAL");

			List<Role> roles = List.of(role, role1);

			List<Role> saveUser = this.roleRepo.saveAll(roles);

			saveUser.forEach(e -> {
				System.out.println(e.getName());
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
