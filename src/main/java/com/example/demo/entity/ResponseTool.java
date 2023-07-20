package com.example.demo.entity;

public class ResponseTool {
    public static ResultDto buildSuccess(Object data) {
        return new ResultDto(200, "Success", data);
    }

    public static ResultDto buildFail(int code, String message, Object data) {
        return new ResultDto(code, message, data);
    }
}

