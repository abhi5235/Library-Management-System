package com.example.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.dto.BookDTO;
import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.exception.StudentAPIException;
import com.example.repository.StudentRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
@RefreshScope
public class StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	RestTemplate restTemplate;

	@Value("${url}")
	String url;

	public Student addStudentInDB(Student student) {
		Optional<Student> findById = studentRepo.findById(student.getStudentId());
		if (findById.isPresent()) {
			throw new StudentAPIException("Student with this studentId is already available");
		}
		return studentRepo.save(student);

	}

//	@CircuitBreaker(name = "student-service", fallbackMethod = "getStudentfallback")
	public Student getStudentDeatilsFromDB(int id) {
		Optional<Student> OptionalStudent = studentRepo.findById(id);
		Student orElseThrow = OptionalStudent.orElseThrow(() -> new StudentAPIException("Student is not available"));
		return orElseThrow;
	}

//	public Student getStudentfallback(int id, Throwable throwable) {
//		System.out.println("-----Fallback----");
//		return new Student();

//	}

	public String deleteStudentById(int id) {
		Optional<Student> findById = studentRepo.findById(id);
		findById.orElseThrow(
				() -> new StudentAPIException("Student which you are trying to delete already unavailable"));
		studentRepo.deleteById(id);
		return "deleted";
	}

	@Transactional
	public String updateDataofStudent(Student student) {
		Optional<Student> ById = studentRepo.findById(student.getStudentId());
		if (ById.isPresent()) {
			Student studentInDB = ById.get();
			studentInDB.setName(student.getName());
			studentInDB.setEmailId(student.getEmailId());
			studentInDB.setPhoneNumber(student.getPhoneNumber());
			return "Student " + student.getStudentId() + " data is updated";
		} else {
			return "Student " + student.getStudentId() + " is not available ";
		}

	}

	public StudentDTO issueBookInBookAPI(int studentId, int bookId) {
		Optional<Student> optionalStudent = studentRepo.findById(studentId);
		Student student = optionalStudent
				.orElseThrow(() -> new StudentAPIException("Student is not available in DataBase"));
		StudentDTO studentDTO = student.convertToDTO();
		ResponseEntity<BookDTO> exchange = restTemplate.exchange(url + "/book/issueBook/{studentId}/{bookId}",
				HttpMethod.PUT, null, BookDTO.class, studentId, bookId);
		BookDTO bookDTO = exchange.getBody();
		studentDTO.setBook(bookDTO);
		return studentDTO;

	}

	public StudentDTO returnBookToBookAPI(int studentId, int bookId) {
		Optional<Student> findById = studentRepo.findById(studentId);
		if (findById.isEmpty()) {
			throw new StudentAPIException("This student has returned the book");
		}
		Student student = findById.get();
		StudentDTO convertToDTO = student.convertToDTO();
		ResponseEntity<BookDTO> exchange = restTemplate.exchange(url + "/book/returnBook/{studentId}/{bookId}",
				HttpMethod.PUT, null, BookDTO.class, studentId, bookId);
		BookDTO bookDTO = exchange.getBody();
		convertToDTO.setBook(bookDTO);
		return convertToDTO;
	}
}
