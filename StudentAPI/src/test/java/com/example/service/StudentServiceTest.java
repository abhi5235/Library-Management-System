package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Student;
import com.example.exception.StudentAPIException;
import com.example.repository.StudentRepository;

@SpringBootTest
class StudentServiceTest {

	@InjectMocks
	StudentService studentService;
	@Mock
	StudentRepository studentRepo;

	@Test
	void testissueBookInBookAPIStudentNotInDbScenario() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		assertThrows(StudentAPIException.class, () -> studentService.issueBookInBookAPI(50, 50));
	}

	@Test
	void testissueBookInBookAPIWithZeroStudentId() {
		assertThrows(StudentAPIException.class, () -> studentService.issueBookInBookAPI(0, 0));
	}

	@Test
	void testaddStudentInDBWithStudentAlreadyAvailable() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(new Student()));
		assertThrows(StudentAPIException.class, () -> studentService.addStudentInDB(new Student()));
	}

	@Test
	void testaddStudentInDBWithSuccess() {
		when(studentRepo.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.empty());
		when(studentRepo.save(ArgumentMatchers.any())).thenReturn(new Student());
		Student student = studentService.addStudentInDB(new Student());
		assertNotNull(student);
	}
	

}
