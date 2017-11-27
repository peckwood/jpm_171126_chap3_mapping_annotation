package com.mybatis3.o2.mappers;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.o2.domain.Address;

public interface AddressMapper {
	@Select("select * from addresses where addr_id = #{id}")
	@Results(id="addressResultMap", 
	value={@Result(column="addr_id", property="addrId")})
	Address findAddressById(Integer id);
}
