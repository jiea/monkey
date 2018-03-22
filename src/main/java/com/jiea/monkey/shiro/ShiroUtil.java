package com.jiea.monkey.shiro;

import com.jiea.monkey.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroUtil {
    // 加密算法
    public static final String hashAlgorithmName = "SHA-256";
    // 循环次数
    public static final int hashIterations = 16;

    public static String sha256(String str, String salt){
        return new SimpleHash(hashAlgorithmName, str, salt, hashIterations).toString();
    }

    public static Subject getSubject(){
        return SecurityUtils.getSubject();
    }

    public static Session getSession(){
        return getSubject().getSession();
    }

    public static User getUser(){
        return (User) getSubject().getPrincipal();
    }

    public static void setSessionAttribute(Object key, Object value){
        getSession().setAttribute(key, value);
    }

    public static Object getSessionAttribute(Object key){
        return getSession().getAttribute(key);
    }
}
