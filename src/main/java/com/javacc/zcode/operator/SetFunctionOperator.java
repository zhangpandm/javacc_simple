package com.javacc.zcode.operator;

import cn.hutool.core.collection.CollUtil;
import com.javacc.zcode.ZpContext;
import com.javacc.zcode.operator.bean.ZcResult;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


/**
 * @description: 集合操作函数算子
 * @author zhangpan
 * @date 2022/5/2
 */
public class SetFunctionOperator implements ZcOperator<Set>{
    /**
     * 函数名标记
     */
    private final int flag;

    /**
     * 函数中的参数列表
     */
    private List<ZcOperator> params;

    /**
     * 运算上下文
     */
    private ZpContext context;

    public SetFunctionOperator(int flag, List<ZcOperator> params, ZpContext context) {
        this.flag = flag;
        this.params = params;
        this.context = context;
    }

    public ZcResult<Set> operator() {
       List<Set> list = new ArrayList<Set>();

       //先把参数列表中结果拿出来放到list数组中
        for (ZcOperator op : params){
            //从{e,...e}集合定义中获取
            if(op instanceof SetOperator){
                SetOperator setOperator = (SetOperator) op;
                list.add(setOperator.operator().getData());
            }
            //从集合的操作运算中获取结果
            if(op instanceof SetFunctionOperator){
                SetFunctionOperator sfp = (SetFunctionOperator) op;
                //注意sfp.operator()会进行递归运算
                list.add(sfp.operator().getData());
            }
        }


        Set set = new LinkedHashSet();
        //利用hutool工具包中集合工具进行集合运算操作
        switch (flag){
            //进行union（并）操作
            case 1:
                if (list.size()>2){
                    set =  CollUtil.unionDistinct(list.get(0),list.get(1),
                            list.subList(2,list.size()).toArray(new Set[0]));
                }else {
                    set = CollUtil.unionDistinct(list.get(0),list.get(1));
                }
                break;
            //进行intersection（交）操作
            case 2:
                if (list.size()>2){
                    set = CollUtil.intersectionDistinct(list.get(0),list.get(1),
                            list.subList(2,list.size()).toArray(new Set[0]));
                }else {
                    set = CollUtil.intersectionDistinct(list.get(0),list.get(1));
                }
                break;
            //进行subtract（差）操作
            case 3:
               set = (Set) CollUtil.subtract(list.get(0),list.get(1));
               break;

        }

        return new ZcResult<Set>(set);

    }
}
