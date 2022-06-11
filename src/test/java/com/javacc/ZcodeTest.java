package com.javacc;

import com.javacc.zcode.ParseException;
import com.javacc.zcode.Zcode;
import org.junit.jupiter.api.Test;

public class ZcodeTest {

    @Test
    void test1() throws ParseException {
        String prog =" a = 1+5*(7-3) ; \n"+
                " println(a); \n"+
                " u1 = {1,4,7+9}; \n"+
                " u2 = {'red','yellow'}; \n"+
                " u3 ={10+6,'red','ind'}; \n"+
                " unionSet = union(u1,u2,u3); \n"+
                " println(unionSet); \n"+
                " interSet = intersect(union(u1,u2),u3); \n"+
                " println(interSet); \n"+
                " println(subtract(u3,intersect(union(u1,u2),u3)));";

        Zcode zcode = new Zcode(prog);
        zcode.parse();
    }
}
