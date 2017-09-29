package com.jungle.weixin.menus;

import com.jungle.weixin.buttons.Button;

public class Menu {

	private Button[] button;
	private String menuid;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

}
