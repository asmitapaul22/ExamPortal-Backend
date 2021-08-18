package com.exam;

import com.exam.Service.UserService;
import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}
	@Autowired
	private UserService userService;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting code");
		//FOR USER ENTITY
//		User user = new User();
//		user.setFirstName("Asmita");
//		user.setLastName("Paul");
//		user.setEmail("asmitapaul2000@gmail.com");
//		user.setPhone("9584890280");
//		user.setUsername("asmitapaul22");
//		user.setPassword("asmita123");
//		user.setProfile("default.png");
//		user.setAbout("about asmita");
//
//		//FOR ROLE ENTITY
//		Role role1 = new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//		//FOR USERROLE ENTITY
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole = new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user);
//		//TO SET USERROLES IN USER
//		userRoleSet.add(userRole);
//		User user1 = this.userService.createUser(user, userRoleSet);
//		System.out.println(user1.getUsername());

	}
}
