package com.example.springbootjsp.util;

import lombok.Data;

@Data
public class Result<T> {

    private String code;

    private Boolean success;

    private T data;

    private String message;

}
