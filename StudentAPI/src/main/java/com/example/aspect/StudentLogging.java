package com.example.aspect;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.example.exception.StudentAPIException;

@Aspect
@Component
public class StudentLogging {

	Log LOGGER = LogFactory.getLog(StudentLogging.class);

	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.addStudent(..))", throwing = "exception")
	public void afterThrowingforAddStudent(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.getStudent(..))", throwing = "exception")
	public void afterThrowingforGetStudent(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.deleteStudent(..))", throwing = "exception")
	public void afterThrowingforDeleteStudent(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());
	}

	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.updtaeStudent(..))", throwing = "exception")
	public void afterThrowingforUpdateStudent(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.issueBook(..))", throwing = "exception")
	public void afterThrowingforIssueBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}
	@AfterThrowing(pointcut = "execution(* com.example.controller.StudentController.returnBook(..))", throwing = "exception")
	public void afterThrowingforReturnBook(StudentAPIException exception) {
		LOGGER.info("EXCEPTION OCCURED");
		LOGGER.error(exception.getMessage());

	}
}
