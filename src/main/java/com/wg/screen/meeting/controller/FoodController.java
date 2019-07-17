package com.wg.screen.meeting.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;
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
	public void getFoodType() {
		List<Record> list = foodService.getFoodTypeList();
		
		renderJson(list);
	}
}
