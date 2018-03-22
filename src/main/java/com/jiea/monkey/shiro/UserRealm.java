package com.jiea.monkey.shiro;

import com.jiea.monkey.domain.User;
import com.jiea.monkey.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;

	/**
	 * 授权（验证权限时调用）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		User user = (User) principalCollection.getPrimaryPrincipal();
		Integer userId = user.getUserId();





		return null;
	}

	/**
	 * 认证（登录时调用）
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		// 查询用户信息
		User user = userService.queryByUsername(token.getUsername());

		if(user == null){
			throw new UnknownAccountException("账号或密码不正确");
		}

		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
		return info;
	}
}
