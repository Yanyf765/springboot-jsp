package com.example.springbootjsp.realm;

import com.example.springbootjsp.entity.SysUser;
import com.example.springbootjsp.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义realm
 * @author jianping.lu
 *
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    private SysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
        // TODO Auto-generated method stub
        System.out.println("认证");
        //shiro判断逻辑
        UsernamePasswordToken user = (UsernamePasswordToken) arg0;
        SysUser newUser = sysUserService.findUser(user.getUsername(),String.copyValueOf(user.getPassword()));
        if(newUser == null){
            //用户名错误
            return null;
        }
        return new SimpleAuthenticationInfo(newUser,newUser.getPassword(),"");
    }
}
