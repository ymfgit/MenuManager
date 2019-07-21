package com.wg.screen.meeting.service;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public interface FoodService {
	
	//食材大全
	public JSONArray getFoodInfo();

	//添加一级食材
	public JSONObject addFoodTypeFirst(JSONObject obj);

	//删除一级食材
	public JSONObject deleteFoodTypeFirst(String id);

	//更新一级食材
	public JSONObject updateFoodTypeFirst(JSONObject obj);
}
