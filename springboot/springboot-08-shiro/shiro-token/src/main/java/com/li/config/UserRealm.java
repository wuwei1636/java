package com.li.config;

import com.li.pojo.User;
import com.li.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

// 自定义的realm        extends AuthorizingRealm
public class UserRealm extends AuthorizingRealm {

    @Autowired
    UserService userService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了授权doGetAuthorizationInfo");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        // 拿到当前登陆的这个对象
        Subject subject = SecurityUtils.getSubject();
        // 取出当前登录的对象，和下面SimpleAuthenticationInfo传的第一个关联
        User currentUser = (User) subject.getPrincipal(); // 拿到user对象
        // 设置当前用户的权限，从数据库中读出
        info.addStringPermission(currentUser.getPerms());

        return info;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        System.out.println("执行了认证doGetAuthorizationInfo");

        UsernamePasswordToken userToken = (UsernamePasswordToken) Token;

        // 连接真实的数据库
        User user = userService.queryUserByName(userToken.getUsername());
        if(user == null){ // 没有这个用户  UnknownAccountException
            return null;
        }




        // 设置 密码的加盐值
        ByteSource salt = ByteSource.Util.bytes(user.getName());
        // 可以加密， MD5 MD5盐值加密
        // 密码认证，shiro自己做
        return new SimpleAuthenticationInfo(
                user, // 当前用户 ，和上面的doGetAuthenticationInfo方法对应
                user.getPwd(),  // 从数据中查处的安全密码
                salt,    // 用户的密码是加盐md5 的
                getName() // 当前 Realm 的名字
        );
    }
}
