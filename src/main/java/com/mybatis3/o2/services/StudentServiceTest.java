package com.mybatis3.o2.services;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis3.o1.domain.Gender;
import com.mybatis3.o1.domain.Student;

public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setup(){
		studentService = new StudentService();
	}
	
	@AfterClass
	public static void teardown(){
		studentService = null;
	}

	@Test
	public void testInsertStudent(){
		Student studentToInsert = new Student();
		studentToInsert.setDob(new Date());
		studentToInsert.setEmail("a1@b.com");
		studentToInsert.setGender(Gender.MALE);
		studentToInsert.setName("Raiden12");
		studentService.insertStudent(studentToInsert);
		
		List<Student> students = studentService.findAllStudents();
		for(Student student:students){
			System.out.println(student);
		}
	}
	
	@Test
	public void testInsertStudentAndSaveGeneratedKey(){
		Student studentToInsert = new Student();
		studentToInsert.setDob(new Date());
		studentToInsert.setEmail("a1@b.com");
		studentToInsert.setGender(Gender.MALE);
		studentToInsert.setName("Raiden12");
		studentService.insertStudentAndSaveGeneratedKey(studentToInsert);
		System.out.println(studentService.selectStudentById(studentToInsert.getStudId()));
	}
	
	@Test
	public void testUpdateStudent(){
		int studentId = 14;
		Student newStudent = new Student();
		newStudent.setStudId(studentId);
		newStudent.setDob(new Date());
		newStudent.setEmail("aaa");
		newStudent.setGender(Gender.FEMALE);
		newStudent.setName("Ahri");
		studentService.updateStudent(newStudent);
		System.out.println(studentService.selectStudentById(studentId));
	}
	@Test
	public void deleteStudentById(){
		int id = 15;
		studentService.deleteStudentById(id);
		System.out.println(studentService.selectStudentById(id));
	}
	
	@Test
	public void selectStudentById(){
		int id = 14;
		Student student = studentService.selectStudentById(id);
		System.out.println(student);
	}
	
	
	@Test
	public void testFindAllStudents(){
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for(Student student:students){
			System.out.println(student);
		}
	}
}
