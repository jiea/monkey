package com.jiea.monkey.service.impl;

import com.google.common.collect.Lists;
import com.jiea.monkey.common.constants.Constant;
import com.jiea.monkey.dao.MenuMapper;
import com.jiea.monkey.domain.Menu;
import com.jiea.monkey.enums.MenuType;
import com.jiea.monkey.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> getUserMenuList(Integer userId) {
		// 系统管理员
		if(Constant.ADMIN == userId){
			return getAllMenus(null);
		}

		// 普通用户菜单列表
		List<Integer> menuIds = menuMapper.queryMenuIdsByUserId(userId);
		return getAllMenus(menuIds);
	}


	public List<Menu> getAllMenus(List<Integer> menuIds){
		// 查询根菜单列表
		List<Menu> menus = queryMenusByParentId(0, menuIds);
		// 递归获取子菜单
		getMenuTreeList(menus, menuIds);

		return menus;
	}

	/**
	 * 递归
	 * @param menus
	 * @param menuIds
	 * @return
	 */
	private List<Menu> getMenuTreeList(List<Menu> menus, List<Integer> menuIds) {
		List<Menu> subMenus = Lists.newArrayList();

		menus.forEach(m -> {
			if(MenuType.CATALOG.getValue() == m.getMenuType()){
				m.setList(getMenuTreeList(queryMenusByParentId(m.getId(), menuIds), menuIds));
			}
			subMenus.add(m);
		});
		return subMenus;
	}

	public List<Menu> queryMenusByParentId(Integer parentId, List<Integer> menuIds){
		List<Menu> menus = queryMenusByParentId(parentId);
		if(Objects.isNull(menuIds)){
			return menus;
		}

		List<Menu> userMenus = Lists.newArrayList();
		menus.forEach(m -> {
			if(menuIds.contains(m.getId())){
				userMenus.add(m);
			}
		});
		return userMenus;
	}


	public List<Menu> queryMenusByParentId(Integer parentId){
		return menuMapper.queryMenusByParentId(parentId);
	}
}
