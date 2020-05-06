package com.dchealth.publichealth.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.dchealth.publichealth.controller.MainController;
import com.dchealth.publichealth.dao.UserMapper;
import com.dchealth.publichealth.dto.UserDto;
import com.dchealth.publichealth.model.User;
import com.dchealth.publichealth.util.CommonUtil;

@Service
@Qualifier("userService")
public class UserServiceImp implements UserService {

	private final static Logger LOG=LoggerFactory.getLogger(UserServiceImp.class);
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<User> findAllUsers() {
		return userMapper.selectAllUsers();
	}
	@Override
	public boolean addUser(UserDto userDto){
		User user=new User();
		user.setAge(userDto.getAge());
		Date birth=userDto.getBirth();
		user.setBirth(birth);
		int age=CommonUtil.getAge(birth);
		LOG.info("age="+age);
		user.setAge(age);
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		int n=userMapper.insertUser(user);
		if (n != 1) {
			return false;
		}
		return true;
	}
	@Override
	public PageInfo<User> findUsersByPage(PageInfo<User> pageInfo) {
		PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
		Page<User> users=userMapper.selectUsersByPage();
		pageInfo = new PageInfo<>(users);
		return pageInfo;
	}
	@Override
	public boolean deleteUser(int id) {
		int n=userMapper.deleteUser(id);
		if (n == 1) {
			return true;
		}
		return false;
	}
	
	 
}
