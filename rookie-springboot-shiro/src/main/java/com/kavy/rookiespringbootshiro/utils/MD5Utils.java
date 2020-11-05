package com.kavy.rookiespringbootshiro.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5Utils {
    public static void main(String[] args) {
        String source = "12345";
        Md5Hash md5Hash = new Md5Hash(source);
        System.out.println("使用Md5加密后的："+md5Hash);

        Md5Hash md5Hash1 = new Md5Hash(source,"广州");
        System.out.println("使用md5加密，加盐后的："+md5Hash1);

        Md5Hash md5Hash2 = new Md5Hash(source,"广西",2);
        System.out.println("使用md5加密，加盐，散列2次后的："+md5Hash2);
    }

    /**
     * md5加密
     */
    public static  String md5(String source, Object salt, Integer hashIterations){

        return new Md5Hash(source,salt,hashIterations).toString();
    }

    /**
     *  加盐
     *   * 对密码加密sha1
     * 	 * @param source  要加密的明文
     * 	 * @param salt  盐
     * 	 * @param hashIterations  散列次数
     * 	 * @return
     */
    public  static String salt(String source, Object salt, Integer hashIterations){
        return new Md5Hash(source,salt,hashIterations).toString();
    }
}
