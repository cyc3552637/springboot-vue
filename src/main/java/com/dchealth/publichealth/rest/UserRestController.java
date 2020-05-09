package com.dchealth.publichealth.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.dchealth.publichealth.dto.Result;
import com.dchealth.publichealth.dto.UserDto;
import com.dchealth.publichealth.model.User;
import com.dchealth.publichealth.service.UserService;

@RestController
@RequestMapping(value="/publichealth/user-rest")
public class UserRestController {

	//springboot默认日志记录
	private final static Logger LOG=LoggerFactory.getLogger(UserRestController.class);

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
    @RequestMapping(value = "/get-by-page", method=RequestMethod.GET)
    public PageInfo<User> findWithBLOBsByPage(@RequestParam(defaultValue = "1",value = "currentPage") Integer pageNum,
                              @RequestParam(defaultValue = "10",value = "pageSize") Integer pageSize){
    	LOG.info("findWithBLOBsByPage");
    	PageInfo<User> pageInfo = new PageInfo<>();
    	pageInfo.setPageNum(pageNum);
    	pageInfo.setPageSize(pageSize);
    	pageInfo=userService.findUsersByPage(pageInfo);
    	return pageInfo;
    }
    
    @RequestMapping(value = "/add-one", method=RequestMethod.POST)
    public Result<?> addUser(@RequestBody UserDto userDto){
    	LOG.info("addUser");
    	Result<?> result=null; 
    	if (userService.addUser(userDto)) {
    		result=Result.success(null).redirect("/html/user/userList.html");
		}else {
			result=Result.fail("addUser error");
		}
    	return result;
    }
    
    @RequestMapping(value = "/delete-one/{id}", method=RequestMethod.POST)
    public Result<?> deleteUser(@PathVariable("id") int id){
    	LOG.info("deleteUser");
    	Result<?> result=null;
    	if (userService.deleteUser(id)) {
    		result=Result.success(null).redirect("/html/user/userList.html");
		}else {
			result=Result.fail("deleteUser error");
		}
    	return result;
    }
}
