package com.jiea.monkey.enums;

public enum MenuType {

	CATALOG(0, "目录"), MENU(1, "菜单"), BUTTON(2, "按钮");

	private int value;

	private String name;

	MenuType(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public String getName(int value){
		for(MenuType menuType : MenuType.values()){
			if(menuType.getValue() == value){
				return menuType.getName(value);
			}
		}
		return null;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
