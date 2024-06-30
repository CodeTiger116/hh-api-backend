package com.hh.hhapiclientsdk;

import com.hh.hhapiclientsdk.client.HhApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("hhapi.client")
@Data
@ComponentScan
public class HhApiClientConfig {

    //通过读取配置拿到
    private String accessKey;
    private String secretKey;

    /**
     * 生成Client
     */
    @Bean
    public HhApiClient hhApiClient() {
        return new HhApiClient(accessKey,secretKey);
    }


}
