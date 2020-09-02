package cn.stylefeng.guns.config;

import cn.stylefeng.guns.core.component.UploadPathProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 文件上传路径配置类
 */
@Configuration
public class UploadPathConfig {

    @Bean
    @ConfigurationProperties("file.upload")
    public UploadPathProperties uploadPathProperties(){
        return new UploadPathProperties();
    }
}
