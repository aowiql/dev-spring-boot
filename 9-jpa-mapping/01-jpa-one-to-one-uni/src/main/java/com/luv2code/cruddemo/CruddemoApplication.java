package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			System.out.println("Hello World");
//			createInstructor(appDAO);

			findInstructor(appDAO);
		};
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associate instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor =
//				new Instructor("Chad", "Dardy", "darby@luv2code.com");
//
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail(
//						"http://www.luv2code.com/youtube",
//						"Luv2 code!!");

		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@luv2code.com");

		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.luv2code.com/youtube",
						"Guitar");


		tempInstructor.setInstructorDetail(tempInstructorDetail);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}
}
