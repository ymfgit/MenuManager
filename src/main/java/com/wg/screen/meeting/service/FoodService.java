package com.wg.screen.meeting.service;

import java.util.List;

import com.jfinal.plugin.activerecord.Record;

public interface FoodService {
	//食材大全
	public List<Record> getFoodTypeList();
}
