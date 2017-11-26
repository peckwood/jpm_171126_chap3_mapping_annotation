package com.mybatis3.o2.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o1.domain.Student;
import com.mybatis3.o1.mappers.StudentMapper;
import com.mybatis3.o1.util.MyBatisSqlSessionFactory;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public void insertStudent(Student student){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public void insertStudentAndSaveGeneratedKey(Student student){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudentAndSaveGeneratedKey(student);
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public void updateStudent(Student student){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.updateStudent(student);
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public void deleteStudentById(Integer id){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.deleteStudent(id);
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
			sqlSession.close();
		}
	}
	
	public Student selectStudentById(Integer id){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentById(id);
		} finally {
			sqlSession.close();
		}
	}
	
	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}
	
	
}
