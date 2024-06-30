package com.hh.hhapiinterface;

import com.hh.hhapiclientsdk.client.HhApiClient;
import com.hh.hhapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HhapiInterfaceApplicationTests {

    @Resource
    private HhApiClient hhApiClient;
    @Test
    void contextLoads() {
        String result = hhApiClient.getNameByGet("hanhu");
        User user = new User();
        user.setUsername("userhanhu");
        String usernameByPost = hhApiClient.getUserNameByPost(user);
        System.out.println(result);
        System.out.println(usernameByPost);
    }

}
