package cn.stylefeng.guns.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.util.TimeZone;

/**
 * 配置Jsckson的行为
 * @author xulu
 *
 */
@Configuration
public class JacksonConfig {
	@Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return new Jackson2ObjectMapperBuilderCustomizer() {
            @Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
            	//忽略null值等基本的都需要进行配置
                jacksonObjectMapperBuilder.serializationInclusion(Include.NON_NULL);
                jacksonObjectMapperBuilder.failOnUnknownProperties(false);
                jacksonObjectMapperBuilder.timeZone(TimeZone.getTimeZone("GMT+8"));
            }

        };
    }

}
