package com.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mapping.entity.AadharCard;
import com.mapping.entity.Student;
import com.mapping.repository.AadharCardRepository;
import com.mapping.repository.StudentRepository;

@SpringBootApplication
public class OneToOneMappingEasyWayApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OneToOneMappingEasyWayApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AadharCardRepository aadharCardRepository;

	@Override
	public void run(String... args) throws Exception {

		// Save the Data into the AadharCard
		AadharCard aadharCard = new AadharCard();
		aadharCard.setNumber("71789999999");
		aadharCardRepository.save(aadharCard);

		// Save the Data into the Student
		Student student = new Student();
		student.setFirstName("Abdul Rasheed");
		student.setLastName("Shaik");
		student.setAadharCard(aadharCard);
		studentRepository.save(student);

		// To fetch the Data From the OneToOne Relationship from the Student Table
		Student studentDisplay = studentRepository.findById(1).get();
		System.out.println("Student Information: " + studentDisplay);
		System.out.println("AadharCard Information: " + studentDisplay.getAadharCard());

		// To fetch the Data from the OneToOne Relationship from the AadharCard Table
		AadharCard aadharCardDisplay = aadharCardRepository.findById(1).get();
		System.out.println("Aadahr Information: " + aadharCardDisplay);

	}

}
