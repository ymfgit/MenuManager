package com.wg.screen.config;

import java.lang.reflect.Method;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;

public class InitDb {

	static Prop prop = PropKit.use("datasource.properties");

	private static String jdbcUrl = "jdbc:mysql://#IP/#DB?characterEncoding=utf8";

	public static void init() {
		initdataSea();

	}

	/**
	 * 初始化dataSea库
	 */
	public static void initdataSea() {
		initDataSource(prop.get("jdbc.ip.datasea"), prop.get("jdbc.db.datasea"), prop.get("jdbc.username.datasea"),
				prop.get("jdbc.password.datasea"), prop.get("jdbc.map.datasea"));
	}

	/**
	 * jfinal初始化数据库
	 * 
	 * @param ip
	 * @param dbname
	 * @param userName
	 * @param password
	 * @param mappingClassName
	 */
	public static void initDataSource(String ip, String dbname, String userName, String password,
			String mappingClassName) {
		try {
			String str_kb = jdbcUrl.replace("#IP", ip).replace("#DB", dbname);
			DruidPlugin dp_kb = new DruidPlugin(str_kb, userName, password);
			Class<?> obj = Class.forName(mappingClassName);
			Method method = obj.getMethod("mapping", ActiveRecordPlugin.class);
			ActiveRecordPlugin arp_kb = new ActiveRecordPlugin(dbname, dp_kb);
			method.invoke(obj, new Object[] { arp_kb });
			arp_kb.setShowSql(false);
			dp_kb.start();
			arp_kb.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
