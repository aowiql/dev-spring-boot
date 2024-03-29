package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDAO) {

		return runner -> {
		// createStudent(studentDAO);

		 createMultipleStudent(studentDAO);

        // readStudent(studentDAO);

		// queryForStudent(studentDAO);

		// queryForStudentLastName(studentDAO);

		// updateStudent(studentDAO);

		// deleteStudent(studentDAO);

		// deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDao studentDAO) {

		System.out.println("Deleting all Students");

		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDao studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}


	private void updateStudent(StudentDao studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);

		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student ... ");
		myStudent.setFirstName("Scooby");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentLastName(StudentDao studentDAO) {
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudent(StudentDao studentDAO) {
		List<Student> theStudents = studentDAO.findAll();

		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDao studentDAO) {
		System.out.println("Creating new Student object ... ");
		Student tempStudent = new Student("Daffy", "Duck", "daffy@luv2Code.com");

		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		System.out.println("Found the student: " + myStudent);
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
