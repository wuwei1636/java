package com.li.config;

import com.li.config.shiroUtils.CustomToken;
import com.li.pojo.Admin;
import com.li.service.AdminService;
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

public class AdminRealm extends AuthorizingRealm {
    @Autowired
    AdminService adminService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        if(principalCollection.getPrimaryPrincipal() instanceof Admin){
            // 拿到当前登陆的这个对象
            Subject subject = SecurityUtils.getSubject();
            // 取出当前登录的对象，和下面SimpleAuthenticationInfo传的第一个关联
            Admin currentAdmin = (Admin) subject.getPrincipal();
            // 设置当前用户的权限，从数据库中读出
            info.addStringPermission(currentAdmin.getPerms());
            return info;
        }else return  null;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        CustomToken adminToken = (CustomToken) Token;
        // 连接真实的数据库
        Admin admin = adminService.queryAdminByName(adminToken.getUsername());
        if(admin == null){ // 没有这个用户  UnknownAccountException
            return null;
        }

        // 在session中设置字符，表示登录成功，目前还没有学会使用token，所以先使用session
        Subject subject1 = SecurityUtils.getSubject();
        Session session = subject1.getSession();
        session.setAttribute("loginUser",admin);


        // 设置 密码的加盐值
        ByteSource salt = ByteSource.Util.bytes(admin.getName());
        // 可以加密， MD5 MD5盐值加密
        // 密码认证，shiro自己做
        return new SimpleAuthenticationInfo(
                admin, // 当前用户 ，和上面的doGetAuthenticationInfo方法对应
                admin.getPassword(),  // 从数据中查处的安全密码
                salt,    // 用户的密码是加盐md5 的
                getName() // 当前 Realm 的名字
        );
    }
}
