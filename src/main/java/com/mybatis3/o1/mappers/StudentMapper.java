package com.mybatis3.o1.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.mybatis3.o1.domain.Student;

public interface StudentMapper {
	@Insert("insert into students(name, email, dob, gender)"
			+ "	values (#{name}, #{email}, #{dob}, #{gender})")
	void insertStudent(Student student);
	
	@Insert("insert into students(name, email, dob, gender)"
			+ "	values (#{name}, #{email}, #{dob}, #{gender})")
	@Options(useGeneratedKeys=true, keyProperty="studId")
	void insertStudentAndSaveGeneratedKey(Student student);
	
	@Update("UPDATE STUDENTS SET NAME=#{name}, EMAIL=#{email} "
			+ ", gender=#{gender}, dob=#{dob} WHERE STUD_ID=#{studId}")
	void updateStudent(Student student);
	
	@Delete("delete from students where stud_id=#{id}")
	void deleteStudent(Integer id);
	
	@Select("select stud_id studId, s.* from students s where stud_id=#{id}")
	Student selectStudentById(Integer id);
	
	@Select("select stud_id studId, s.* from students s")
	List<Student> findAllStudents();
}
