package com.wg.screen.meeting.service.impl;

import java.util.List;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.FoodService;

import wg.media.screen.model.datasea.FoodTypeFirst;
import wg.media.screen.model.datasea.FoodTypeSecond;

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

	/**
	 * 更新二级食材
	 */
	@Override
	public JSONObject updateFoodTypeSecond(JSONObject obj) {
		FoodTypeSecond typeSecond = FoodTypeSecond.dao.findById(obj.getInteger("id"));
		typeSecond.setName(obj.getString("type_first_id"));
		typeSecond.setName(obj.getString("name"));
		typeSecond.setSort(obj.getInteger("sort"));
		
		boolean result = typeSecond.update();
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;
	}

	/**
	 * 添加二级食材
	 */
	@Override
	public JSONObject addFoodTypeSecond(JSONObject obj) {
		FoodTypeSecond typeSecond = new FoodTypeSecond();
		typeSecond.setName(obj.getString("type_first_id"));
		typeSecond.setName(obj.getString("name"));
		typeSecond.setSort(obj.getInteger("sort"));
		
		boolean result = typeSecond.save();
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;
	}

	/**
	 * 删除二级食材类型
	 */
	@Override
	public JSONObject deleteFoodTypeSecond(String id) {
		boolean result = FoodTypeSecond.dao.deleteById(id);
		JSONObject object = new JSONObject();
		if (result) {
			object.put("result", "success");
		} else {
			object.put("result", "fail");
		}
		return object;

	}

	/**
	 * 查看一级食材
	 */
	@Override
	public List<Record> getFoodTypeFirstInfo(JSONObject obj) {
		String sql = "select * from foodTypeFirst where 1=1";
		if (!StringUtils.isEmpty(obj.getString("name"))) {
			sql += " and name = '" + obj.getString("name")+ "'";
		}
		
		if (!StringUtils.isEmpty(obj.getString("sort"))) {
			sql += " and sort = '" + obj.getString("sort")+ "'";
		}
		
		List<Record> list = Db.find(sql);
		return list;
	}

	/**
	 * 查看二级食材
	 */
	@Override
	public List<Record> getFoodTypeSecondInfo(JSONObject obj) {
		String sql = "select * from foodTypeSecond where 1=1";
		
		if (!StringUtils.isEmpty(obj.getString("type_first_id"))) {
			sql += " and typeFirstId = '" + obj.getString("type_first_id")+ "'";
		}
		
		if (!StringUtils.isEmpty(obj.getString("name"))) {
			sql += " and name = '" + obj.getString("name")+ "'";
		}
		
		if (!StringUtils.isEmpty(obj.getString("sort"))) {
			sql += " and sort = '" + obj.getString("sort")+ "'";
		}
		
		List<Record> list = Db.find(sql);
		return list;
	}
}
