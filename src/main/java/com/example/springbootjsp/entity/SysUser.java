package com.example.springbootjsp.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SysUser implements Serializable {
    private Integer userId;

    private String userCode;

    private String userName;

    private String status;

    private String password;

    private Date createDate;

    private Integer createBy;

    private Date lastUpdateDate;

    private Integer lastUpdateBy;

    private Integer roleId;
}