package com.ming.car.utils;

import lombok.Data;

/**
 * @author chao
 * @date 2023/03/22 9:38
 * @desciption 全局统一返回结果类
 */
@Data
public class Result<T> {
    //返回码
    private Integer status;

    //返回消息
    private String msg;

    //返回数据
    private T data;

    public Result(){}

    // 返回数据
    public static <T> Result<T> build(T data) {
        Result<T> result = new Result<T>();
        if (data != null){
            result.setData(data);
        }
        result.setMsg("ok");
        result.setStatus(200);
        return result;
    }
}
