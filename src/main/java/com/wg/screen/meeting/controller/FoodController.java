package com.wg.screen.meeting.controller;

import com.alibaba.fastjson.JSONArray;
import com.jfinal.core.Controller;
import com.wg.screen.meeting.service.FoodService;
import com.wg.screen.meeting.service.impl.FoodServiceImpl;

/**
 * 
 * @description 食材管理
 * @author ymf
 * @date 2019年7月16日
 */
public class FoodController extends Controller {

	FoodService foodService = new FoodServiceImpl();
	public void index() {
		renderJson("1231");
	}
	
	/**
	 * 食材大全
	 */
	public void getFoodInfo() {
		JSONArray object = foodService.getFoodInfo();
		
		renderJson(object);
	}
}
