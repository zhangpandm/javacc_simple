package com.javacc.zcode.operator.bean;


/**
 * @description: 无实际返回结果的算子结果类
 * @author zhangpan
 * @date 2022/5/1
 */
public class ZcVoid  extends ZcResult<ZcVoid>{
    private final static  ZcVoid zcVoid = new ZcVoid();

    public ZcVoid(ZcVoid data) {
        super(data);
    }

    private ZcVoid(){
        super(zcVoid);
    }

    @Override
    public ZcVoid getData() {
        throw new  UnsupportedOperationException("ZcVoid Unsupported");
    }

    public static ZcVoid getInstance(){
        return zcVoid;
    }
}
