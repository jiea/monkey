package com.jiea.monkey.service.impl;

import com.jiea.monkey.dao.UserMapper;
import com.jiea.monkey.domain.User;
import com.jiea.monkey.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }
}
