package com.hh.hhapiclientsdk.utils;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

public class SignUtil {
    //签名生成算法
    public static String getSign(String accessKey,String nonce,String timestamp,String secretKey){
        //md5 加密 Hutool
        Digester md5 = new Digester(DigestAlgorithm.SHA256);
        return md5.digestHex(accessKey + "&" + nonce + "&" + timestamp + "&" + secretKey);
    }
}
