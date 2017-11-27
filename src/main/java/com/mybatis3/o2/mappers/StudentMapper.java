package com.mybatis3.o2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mybatis3.o2.domain.Student;

public interface StudentMapper {
	//normal @Results, @Results is the counterpart of resultMap in XML configuration
	@Select("select * from students s where stud_id=#{id}")
	@Results(id = "studentResultSet", value = { @Result(column = "stud_id", property = "studId"),
			@Result(column = "addr_id", property = "address.addrId") })

	Student selectStudentById(Integer id);

	//reuse @Results
	@Select("select * from students s")
	@ResultMap("studentResultSet")
	List<Student> findAllStudents();
	
	//nested select
	@Select("select * from students s where stud_id=#{id}")
	@Results(id = "studentWithAddressResultSet", 
		value = { 
			@Result(column = "stud_id", property = "studId"),
			@Result(column="addr_id", property="address",
			one=@One(select="com.mybatis3.o2.mappers.AddressMapper.findAddressById"))}
	)
	Student selectStudentWithAdressById_nestedSelect(Integer id);
	
}
