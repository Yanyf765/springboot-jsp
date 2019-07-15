package com.example.springbootjsp.service;

import com.example.springbootjsp.entity.SysUser;

public interface SysUserService {

    SysUser findUser(String name,String password);
}
