package com.wg.screen.meeting.service.impl;

import java.util.List;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.wg.screen.meeting.service.UserService;

public class UserServiceImpl implements UserService{

	/**
	 * 获取菜单信息
	 */
	@Override
	public List getMenuList() {
		String sql = "select * from menu";
		List<Record> list = Db.find(sql);
		
		return list;
	}

}
