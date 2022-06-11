package com.javacc.zcode.operator;

import com.javacc.zcode.operator.bean.ZcResult;

/**
 * @description: 算子定义接口
 * @author zhangpan
 * @date 2022/5/1
 */
public interface ZcOperator<T> {

    /**
     * 算子运算操作
     * @return ZcResult 返回结果
     */
    ZcResult<T> operator();

}
