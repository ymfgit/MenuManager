package com.wg.screen.meeting.service;


import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;

public interface FoodService {
	
	//食材大全
	public JSONArray getFoodInfo();

	//添加一级食材
	public JSONObject addFoodTypeFirst(JSONObject obj);

	//删除一级食材
	public JSONObject deleteFoodTypeFirst(String id);

	//更新一级食材
	public JSONObject updateFoodTypeFirst(JSONObject obj);

	//查看一级食材
	public List<Record> getFoodTypeFirstInfo(JSONObject obj);

	//更新二级食材
	public JSONObject updateFoodTypeSecond(JSONObject obj);

	//添加二级食材
	public JSONObject addFoodTypeSecond(JSONObject obj);

	//删除二级食材
	public JSONObject deleteFoodTypeSecond(String id);

	//查看二级食材
	public List<Record> getFoodTypeSecondInfo(JSONObject obj);

}
