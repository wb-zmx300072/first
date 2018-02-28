package com.excelib.filter;
import org.springframework.context.annotation.Bean;  
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;  
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;  
/** 
 * Created by xin on 15/1/20. 
 */  
@EnableRedisHttpSession  
public class SessionConfig {  
    @Bean  
    public JedisConnectionFactory connectionFactory() {  
        return new JedisConnectionFactory();  
    }  
}  
