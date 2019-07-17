package com.wg.screen.meeting.controller;

import com.jfinal.core.Controller;
import com.wg.screen.meeting.service.UserService;
import com.wg.screen.meeting.service.impl.UserServiceImpl;

/**
 * 
 * @description 用户管理
 * @author ymf
 * @date 2019年7月16日
 */
public class UserController extends Controller {

	UserService userService = new UserServiceImpl();
	public void index() {
		renderJson("1231");
	}
	
	public void getMenu() {
	}
}
