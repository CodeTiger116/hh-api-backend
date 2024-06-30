package com.hh.hhapiinterface.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

@Deprecated
public class SignUtil {
    //签名生成算法
    public static String getSign(String accessKey,String once,String timestamp,String secretKey){
        //md5 加密 Hutool
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        return md5.digestHex(accessKey + "&" + once + "&" + timestamp + "&" + secretKey);
    }
}
