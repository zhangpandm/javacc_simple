package com.javacc.zcode.operator.bean;

/**
 * @description: 算子运算的结果类
 * @author zhangpan
 * @date 2022/5/1
 */
public class ZcResult <T>{
    private final T data;

    public ZcResult(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

}
