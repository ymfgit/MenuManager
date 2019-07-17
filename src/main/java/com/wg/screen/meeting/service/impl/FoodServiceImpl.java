package com.wg.screen.meeting.service.impl;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.FoodService;
import com.wg.screen.meeting.service.MenuService;

public class FoodServiceImpl implements FoodService{

	/**
	 * 食材大全
	 */
	@Override
	public List<Record> getFoodTypeList() {
		String sql = "select f1.name fname, typeFirstId,f2.name sname from foodTypeFirst f1,foodTypeSecond f2 where f1.id = f2.typeFirstId";
		List<Record> list = Db.find(sql);
		return list;
	}

}
