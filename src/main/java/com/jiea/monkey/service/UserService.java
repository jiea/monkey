package com.jiea.monkey.service;

import com.jiea.monkey.domain.User;

public interface UserService {

    int addUser(User user);

	/**
	 * 根据用户名查找User
	 * @param username
	 * @return
	 */
	User queryByUsername(String username);
}
