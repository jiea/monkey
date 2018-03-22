package com.jiea.monkey.common.config;

import org.apache.shiro.session.mgt.SessionManager;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

    public SessionManager sessionManager(){
        return null;
    }
}
