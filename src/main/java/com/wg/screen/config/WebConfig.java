package com.wg.screen.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;
import com.wg.screen.meeting.controller.FoodController;
import com.wg.screen.meeting.controller.MenuController;
import com.wg.screen.meeting.controller.UserController;

public class WebConfig extends JFinalConfig {
	static Prop prop = PropKit.use("datasource.properties");

	@Override
	public void configConstant(Constants me) {
		InitDb.init();
		me.setDevMode(prop.getBoolean("devMode", false));
		me.setEncoding("UTF-8");
		me.setError401View("/login.html");
		me.setError403View("/login.html");
		me.setError404View("/login.html");
		me.setError500View("/login.html");
		me.setViewType(ViewType.FREE_MARKER);
		// 默认10M,此处设置为最大20M
		me.setMaxPostSize(1024 * 1024 * 20);
	}

	// 路由
	@Override
	public void configRoute(Routes me) {
		me.setBaseViewPath("page");
		me.add("/menu", MenuController.class);
		me.add("/food", FoodController.class);
		me.add("/user", UserController.class);

	}

	@Override
	public void configEngine(Engine arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configHandler(Handlers arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configInterceptor(Interceptors arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void configPlugin(Plugins arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * 建议使用 JFinal 手册推荐的方式启动项目 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
	 */
	public static void main(String[] args) {
		JFinal.start("src/main/webapp", 8088, "/");
	}

}
