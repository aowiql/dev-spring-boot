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
//			createStudent(studentDAO);

			createMultipleStudent(studentDAO);
		};
	}

	private void createMultipleStudent(StudentDao studentDAO) {
		// create multiple student
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Jon", "Doe", "john@luv2Code.com");
		Student tempStudent2 = new Student("Mary", "Public", "marry@luv2Code.com");
		Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@luv2Code.com");

		// save the student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

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
