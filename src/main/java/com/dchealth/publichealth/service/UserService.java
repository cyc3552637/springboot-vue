package com.dchealth.publichealth.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.dchealth.publichealth.dto.UserDto;
import com.dchealth.publichealth.model.User;

public interface UserService {
	public List<User> findAllUsers();
	
	public PageInfo<User> findUsersByPage(PageInfo<User> pageInfo);
	
	public boolean addUser(UserDto user);
	
	public boolean deleteUser(int id);
}
