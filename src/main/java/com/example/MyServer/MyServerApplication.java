package com.example.MyServer;

import com.example.MyServer.domain.User;
import com.example.MyServer.rest.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyServerApplication.class, args).getBean(UserController.class).addUser(User.builder().login("login").city("Vjcrd").password("123").starsValue(5.0).build());
	}

}
