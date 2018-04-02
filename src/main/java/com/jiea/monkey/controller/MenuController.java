package com.jiea.monkey.controller;

import com.jiea.monkey.domain.Menu;
import com.jiea.monkey.domain.vo.Rtn;
import com.jiea.monkey.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("menu")
public class MenuController extends AbstractController {

	@Autowired
	private MenuService menuService;

	/**
	 * 导航菜单
	 * @return
	 */
	@GetMapping("nav")
	@ResponseBody
	public Rtn nav(){
		List<Menu> menus = menuService.getUserMenuList(1);
		return Rtn.ok().put("menus", menus);
	}
}
