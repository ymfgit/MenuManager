package com.wg.screen.meeting.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
	
	//一级食材类型管理
	public void addFoodTypeFirst() {
		JSONObject obj = new JSONObject();
		String name = getPara("name");
		String sort = getPara("sort");
		obj.put("name", name);
		obj.put("sort", sort);
		JSONObject result = foodService.addFoodTypeFirst(obj);
		renderJson(result);
	}
	
	//删除一级食材
	public void deleteFoodTypeFirst() {
		String id = getPara("id");
		JSONObject result = foodService.deleteFoodTypeFirst(id);
		
		renderJson(result);
	}
	
	//更新一级食材
	public void updateFoodTypeFirst() {
		JSONObject obj = new JSONObject();
		String id = getPara("id");
		String name = getPara("name");
		String sort = getPara("sort");
		obj.put("id", id);
		obj.put("name", name);
		obj.put("sort", sort);
		
		JSONObject result = foodService.updateFoodTypeFirst(obj);
		renderJson(result);
	}
	
}
