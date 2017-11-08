package com.test.untile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class SecurityUtil {
    //使用MD5加密
    public static String encrypt(String src){
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
           // md5.update(src.getBytes());
            //加密
            byte[] ms=md5.digest(src.getBytes());
            StringBuilder sd=new StringBuilder();
            for (int i=0;i<ms.length;i++){
                int x=(int)ms[i]&0xff;
                //加盐
                x=x+1;
                if (x<16){
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }
            return sd.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
