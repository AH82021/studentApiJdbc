package dev.armancodeblcok.studentapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@ComponentScan enable the Spring Boot to find all the components in the application
//@EnableAutoConfiguration enable the Spring Boot automatic configuration.SpringBoot will automatically
// configure your project based on the dependencies. For example
@SpringBootApplication
public class StudentApiApplication {
 private static final Logger log = LoggerFactory.getLogger(StudentApiApplication.class);
	public static void main(String[] args) {


		SpringApplication.run(StudentApiApplication.class, args);
  log.info("Application started successfully 😍");
	}

}
