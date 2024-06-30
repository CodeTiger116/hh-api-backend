package com.hh.hhapiinterface.controller;

import com.hh.hhapiclientsdk.model.User;
import com.hh.hhapiclientsdk.utils.SignUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 名字API
 * @author hanhu
 */
@RestController
@RequestMapping("/name")
public class NameController {

    @GetMapping("/get")
    public String getNameByGet(String name) {

        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/user")
    public String getUsernameByPost(@RequestBody User user, HttpServletRequest request) {
        //校验
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        // todo 实际情况应该是去数据库中查是否已分配给用户
        //简单校验
        if(!accessKey.equals("hanhu")){
            throw new RuntimeException("无权限");
        }
        if(Long.parseLong(nonce) > 10000){
            throw new RuntimeException("无权限");
        }
        //todo 实际是从数据库拿到secretKey
        String serverSign =  SignUtil.getSign(accessKey,nonce,timestamp,"123456");
        if(!sign.equals(serverSign)){
            throw new RuntimeException("无权限");
        }
        return "POST 用户名字是" + user.getUsername();
    }
}
