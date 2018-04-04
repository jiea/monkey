package com.jiea.monkey.service;

import com.jiea.monkey.domain.Menu;

import java.util.List;

public interface MenuService {

	/**
	 * 获取用户菜单列表
	 * @param uesrId
	 * @return
	 */
	List<Menu> getUserMenuList(Integer uesrId);

	/**
	 * 获取所有的菜单
	 * @return
	 */
	List<Menu> getMenus();
}
