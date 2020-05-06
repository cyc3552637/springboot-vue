package com.dchealth.publichealth.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;
import com.dchealth.publichealth.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface UserMapper {
	public int insertUser(User user);
	
	public List<User> selectAllUsers();
	
	public Page<User> selectUsersByPage();
	
	public int deleteUser(@Param("id") int id);
	
}
