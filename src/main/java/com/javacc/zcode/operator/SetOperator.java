package com.javacc.zcode.operator;

import com.javacc.zcode.operator.bean.ZcResult;

import java.util.Set;


/**
 * @description: 集合定义算子
 * @author zhangpan
 * @date 2022/5/1
 */
public class SetOperator implements ZcOperator<Set>{

    /**
     * 结果集
     */
    private ZcResult<Set> result;

    public SetOperator(Set data){
        result = new ZcResult<Set>(data);
    }

    public ZcResult<Set> operator() {
        return result;
    }
}
