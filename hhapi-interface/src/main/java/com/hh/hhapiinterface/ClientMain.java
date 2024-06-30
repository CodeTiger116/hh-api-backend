package com.hh.hhapiinterface;

import com.hh.hhapiinterface.client.HhApiClient;
import com.hh.hhapiinterface.model.User;

@Deprecated
public class ClientMain {
    public static void main(String[] args) {

        HhApiClient hhApiClient = new HhApiClient();
        String result1 = hhApiClient.getNameByGet("hanhu");
        System.out.println(result1);

        String result2 = hhApiClient.getNameByPost("hanhu");
        System.out.println(result2);

        User user = new User();
        user.setUsername("userhanhu");
        String result3 = hhApiClient.getUserNameByPost(user);
        System.out.println(result3);
    }
}
