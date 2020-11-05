package com.kavy.rookiespringbootredis.util;

public class Singleto {

    private static class SingletoClass{
        private static final Singleto INSTACE = new Singleto();
    }
    private Singleto(){}

    public static final Singleto getInstance(){
        return SingletoClass.INSTACE;
    }
}
