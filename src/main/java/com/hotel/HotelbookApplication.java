package com.hotel;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hotel.exception.UserFoundException;
import com.hotel.model.Role;
import com.hotel.model.User;
import com.hotel.model.UserRole;
import com.hotel.services.UserService;

@SpringBootApplication
public class HotelbookApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(HotelbookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try {
		System.out.println("starting code");
		//
		            User user = new User();

		            user.setFirstName("Admin");
		            user.setLastName("Admin");
		            user.setUsername("admin");
		            user.setPassword(this.bCryptPasswordEncoder.encode("1234"));
		            user.setEmail("admin@gmail.com");
		            user.setProfile("default.png");

		            Role role1 = new Role();
		            role1.setRoleId(44L);
		            role1.setRoleName("ADMIN");

		            Set<UserRole> userRoleSet = new HashSet<>();
		            UserRole userRole = new UserRole();

		            userRole.setRole(role1);

		            userRole.setUser(user);

		            userRoleSet.add(userRole);

		            User user1 = this.userService.createUser(user, userRoleSet);
		            System.out.println(user1.getUsername());


		        } 
					catch(UserFoundException e) {
		            e.printStackTrace();

		        }
	}
}
