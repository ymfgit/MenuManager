package com.wg.screen.meeting.controller;

import java.util.List;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.MenuService;
import com.wg.screen.meeting.service.impl.MenuServiceImpl;

/**
 * 
 * @description 菜单管理
 * @author ymf
 * @date 2019年7月16日
 */
public class MenuController extends Controller {

	MenuService menuService = new MenuServiceImpl();
	public void index() {
		renderJson("1231");
	}
	
	public void getMenu() {
		List<Record> menuList = menuService.getMenuList();
		renderJson(menuList);
	}
}
