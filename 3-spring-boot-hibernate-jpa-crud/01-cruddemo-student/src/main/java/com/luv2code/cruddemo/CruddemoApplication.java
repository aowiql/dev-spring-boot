package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO) {

		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDao studentDAO) {

		// create

		System.out.println("Creating new Student object...");
		Student tempStudent = new Student("Paul", "Doe", "paul@luv2Code.com");

		// save
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

}
