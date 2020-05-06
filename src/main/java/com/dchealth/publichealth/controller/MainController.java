package com.dchealth.publichealth.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	//springboot默认日志记录
	private final static Logger LOG=LoggerFactory.getLogger(MainController.class);
	
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public ModelAndView layout(ModelAndView mv) {
    	LOG.info("layout");
    	mv.setViewName("layout");
    	return mv;
    }
}
