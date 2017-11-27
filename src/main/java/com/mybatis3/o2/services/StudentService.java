package com.mybatis3.o2.services;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mybatis3.o2.domain.Student;
import com.mybatis3.o2.mappers.StudentMapper;
import com.mybatis3.o2.util.MyBatisSqlSessionFactory;


public class StudentService {
	private Logger logger = LoggerFactory.getLogger(getClass());

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
	
	public Student selectStudentWithAdressById_nestedSelect(Integer id){
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAdressById_nestedSelect(id);
		} finally {
			sqlSession.close();
		}
	}
	
	
}
