package com.example.springbootjsp.controller;

import com.example.springbootjsp.entity.SysUser;
import com.example.springbootjsp.util.MD5Util;
import com.example.springbootjsp.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {

    @RequestMapping("/login")
    public Result<SysUser> schoolLogin(@RequestParam(value = "username") String username,
                                       @RequestParam(value = "password") String password,
                                       HttpServletRequest request) {
        System.out.println("开始登陆");
        //设置永不过期
//        SecurityUtils.getSubject().getSession().setTimeout(-1000L);
        Subject subject = SecurityUtils.getSubject();
        SysUser sysUser;
        try {
            // 调用安全认证框架的登录方法
            password = MD5Util.md5(password);
            subject.login(new UsernamePasswordToken(username, password));
            sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
            String sessionId = request.getSession().getId();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
        Result<SysUser> result = new Result<>();
        result.setCode("200");
        result.setSuccess(true);
        result.setData(sysUser);
        return result;
    }
}
