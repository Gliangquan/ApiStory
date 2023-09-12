package com.apistory.sdk;


import com.apistory.sdk.client.ApiStorySdk;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("story.client")
@ComponentScan
@Data
public class ApiStroySdkApplication {
    private String accessKey;

    private String secretKey;

    @Bean
    public ApiStorySdk ApiStorySdk() {
        return new ApiStorySdk(accessKey, secretKey);
    }

}
