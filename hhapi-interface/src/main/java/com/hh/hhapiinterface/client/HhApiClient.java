package com.hh.hhapiinterface.client;

import cn.hutool.core.util.RandomUtil;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.hh.hhapiinterface.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;
import java.util.Map;

import static com.hh.hhapiinterface.utils.SignUtil.getSign;


/**
 * 调用第三方接口的客户端
 */
@Deprecated
public class HhApiClient {
    //先写死
    private String accessKey = "hanhu";
    private String secretKey = "123456";
    private String nonce = RandomUtil.randomNumbers(4);
    private String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
    private String sign = getSign(accessKey,nonce,timestamp,secretKey);




    public String getNameByGet(String name) {

        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:8123/api/name/get", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(@RequestParam String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);

        String result= HttpUtil.post("http://localhost:8123/api/name/post", paramMap);
        System.out.println(result);
        return result;
    }

    private Map<String,String> getHashMap(){
        //todo 密码不能以明文方式传递
        Map<String,String> map = new HashMap<>();
        map.put("accessKey", accessKey);
        //map.put("secretKey", secretKey);
        map.put("nonce", nonce);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        return map;
    }
    public String getUserNameByPost(@RequestBody User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(getHashMap())
                .body(json)
                .execute();
        //调用body方法获取响应内容
        String result = httpResponse.body();
        System.out.println(httpResponse.getStatus());
        System.out.println(result);
        return result;
    }
}
