package com.jiea.monkey.shiro;

import com.jiea.monkey.common.exception.MonkeyException;
import com.jiea.monkey.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.security.Key;
import java.util.Objects;

public class ShiroUtils {
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

    public static Object removeSession(Object key){
        return getSession().removeAttribute(key);
    }

    public static String getKaptcha(String key){
        Object kaptcha = getSessionAttribute(key);
        if(Objects.isNull(kaptcha)){
            throw new MonkeyException("验证码已失效");
        }
        removeSession(key);
        return kaptcha.toString();
    }
}
