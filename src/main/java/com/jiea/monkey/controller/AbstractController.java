package com.jiea.monkey.controller;

import com.jiea.monkey.domain.User;
import com.jiea.monkey.shiro.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	protected User getUser(){
		return ShiroUtils.getUser();
	}

	protected Integer getUesrId(){
		return getUser().getUserId();
	}

}
