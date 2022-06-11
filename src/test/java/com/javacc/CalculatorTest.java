package com.javacc;


import com.javacc.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CalculatorTest {

    public void testCalc() throws Exception {

        boolean isBeak = false;
        BufferedReader reader;
        String expr ="";
       com.javacc.calculator.Calculator calculator ;
        while (!isBeak){
            System.out.println("please input four arithmetic expressions , input quit exit");
            reader = new BufferedReader(new InputStreamReader(System.in));
            expr = reader.readLine();
            if(!"quit".equals(expr)){
                calculator = new Calculator(expr);
                double res = calculator.calc();
                System.out.println(res);
            }else {
                isBeak =true;
            }

        }
    }

    public static void main(String[] args) {
        CalculatorTest calculatorTest = new CalculatorTest();
        try {
            calculatorTest.testCalc();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
}
