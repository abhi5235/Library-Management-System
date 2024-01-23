package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		Student addStudent = studentService.addStudentInDB(student);
		return new ResponseEntity<Student>(addStudent, HttpStatus.CREATED);
	}

	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		return studentService.getStudentDeatilsFromDB(id);
	}

	@DeleteMapping("/student/{studentId}")
	public String deleteStudent(@PathVariable("studentId") int id) {
		return studentService.deleteStudentById(id);
	}

	@PutMapping("/student/updateStudent")
	public String updtaeStudent(@RequestBody Student student) {
		return studentService.updateDataofStudent(student);
	}

	@GetMapping("/student/issueBook")
	public ResponseEntity<StudentDTO> issueBook(int studentId, int bookId) {
		StudentDTO sdto = studentService.issueBookInBookAPI(studentId, bookId);
		return new ResponseEntity<StudentDTO>(sdto, HttpStatus.OK);
	}
	@GetMapping("student/returnBook")
	public StudentDTO returnBook(int studentId,int bookId) {
		return studentService.returnBookToBookAPI(studentId, bookId);
	}
}
