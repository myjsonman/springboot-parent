package com.kavy.rookiespringbootredis.util;

import com.kavy.rookiespringbootredis.bean.Cal;

public class TestCal {
    public static void main(String[] args) {

       /* cal2(10, 20, new Cal() {
            @Override
            public int cal1(int a, int b) {
                return a+b;
            }
        });*/

       cal2(12,39,(int a,int b)->
            a+b
       );
    }
    public static void cal2(int a, int b, Cal cal){
        int sum = cal.cal1(a,b);
        System.out.println(sum);
    }
}
