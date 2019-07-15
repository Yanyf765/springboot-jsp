package com.example.springbootjsp.service.impl;

import com.example.springbootjsp.dao.SysUserMapper;
import com.example.springbootjsp.entity.SysUser;
import com.example.springbootjsp.entity.SysUserExample;
import com.example.springbootjsp.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser findUser(String name, String password) {
        SysUserExample sysUserExample = new SysUserExample();
        sysUserExample.createCriteria().andUserNameEqualTo(name).andPasswordEqualTo(password);
        List<SysUser> sysUsers = sysUserMapper.selectByExample(sysUserExample);
        SysUser sysUser = null;
        if(!CollectionUtils.isEmpty(sysUsers)){
            sysUser = sysUsers.get(0);
        }
        return sysUser;
    }
}
