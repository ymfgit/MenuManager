package com.wg.screen.meeting.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.FoodService;

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
	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		JSONObject object = new JSONObject();
		object.put("猪肉", "猪肝");
		object.put("猪肉", "猪腿");
		object.put("猪肉", "猪肠");
		array.add(object);
		obj.put("肉类", array);
		
		System.out.println(obj);
	}
}
