package com.wg.screen.meeting.controller;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
	
	//查看一级食材
	public void getFoodTypeFirstInfo() {
		String name = getPara("name");
		String sort = getPara("sort");
		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("sort", sort);
		List<Record> list = foodService.getFoodTypeFirstInfo(obj);
		
		renderJson(list);
	}
	
	//二级食材类型管理
	public void addFoodTypeSecond() {
		JSONObject obj = new JSONObject();
		String typeFirstId = getPara("type_first_id");
		String name = getPara("name");
		String sort = getPara("sort");
		obj.put("type_first_id", typeFirstId);
		obj.put("name", name);
		obj.put("sort", sort);
		JSONObject result = foodService.addFoodTypeSecond(obj);
		renderJson(result);
	}
	
	//删除一级食材
	public void deleteFoodTypeSecond() {
		String id = getPara("id");
		JSONObject result = foodService.deleteFoodTypeSecond(id);
		
		renderJson(result);
	}
	
	//更新一级食材
	public void updateFoodTypeSecond() {
		JSONObject obj = new JSONObject();
		String id = getPara("id");
		String typeFirstId = getPara("type_first_id");
		String name = getPara("name");
		String sort = getPara("sort");
		obj.put("id", id);
		obj.put("type_first_id", typeFirstId);
		obj.put("name", name);
		obj.put("sort", sort);
		
		JSONObject result = foodService.updateFoodTypeSecond(obj);
		renderJson(result);
	}
	
	//查看一级食材
	public void getFoodTypeSecondInfo() {
		String typeFirstId = getPara("type_first_id");
		String name = getPara("name");
		String sort = getPara("sort");
		JSONObject obj = new JSONObject();
		obj.put("type_first_id", typeFirstId);
		obj.put("name", name);
		obj.put("sort", sort);
		List<Record> list = foodService.getFoodTypeSecondInfo(obj);
		
		renderJson(list);
	}
	
}
