package com.wg.screen.meeting.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.FoodService;

import wg.media.screen.model.datasea.FoodTypeFirst;

public class FoodServiceImpl implements FoodService{

	/**
	 * 食材大全
	 */
	public JSONArray getFoodInfo() {
		String sql = "select * from foodTypeFirst ";
		List<Record> list = Db.find(sql);
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		for (Record record : list) {
			JSONObject firstOjbect = new JSONObject();
			String secondSql = "select * from foodTypeSecond where typeFirstId = '" + record.getInt("id") + "'";
			
			List<Record> secondList = Db.find(secondSql);
			for (Record record2 : secondList) {
				JSONObject object = new JSONObject();
				String foodSql = "select * from food where typeFirstId = '" + record.getInt("id")+ "' and typeSecondId = '" + record2.getInt("id") + "'";
				object.put("list", Db.find(foodSql));
				object.put("secondName", record2.getStr("name"));
				array.add(object);
			}
			firstOjbect.put("firstName",  record.getStr("name"));
			array.add(firstOjbect);
		}
		return array;
		
	}
	
	/**
	 * 添加一级食材
	 */
	@Override
	public JSONObject addFoodTypeFirst(JSONObject obj) {
		FoodTypeFirst typeFirst = new FoodTypeFirst();
		typeFirst.setName(obj.getString("name"));
		typeFirst.setSort(obj.getInteger("sort"));
		
		boolean result = typeFirst.save();
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;
	}

	/**
	 * 删除一级食材
	 */
	@Override
	public JSONObject deleteFoodTypeFirst(String id) {
		boolean result = FoodTypeFirst.dao.deleteById(id);
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;
	}

	/**
	 * 更新一级食材
	 */
	@Override
	public JSONObject updateFoodTypeFirst(JSONObject obj) {
		FoodTypeFirst typeFirst = FoodTypeFirst.dao.findById(obj.getInteger("id"));
		typeFirst.setName(obj.getString("name"));
		typeFirst.setSort(obj.getInteger("sort"));
		
		boolean result = typeFirst.update();
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;
	}
}
