package org.gfg.Spring_Minor;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;


//redis-cli -h redis-17213.c9.us-east-1-4.ec2.redns.redis-cloud.com -p 17213 -a WTOsHK1Zk8iRYOtJNc7PZTwuvVkLWAPN

@Configuration
public class RedisConfig {

    @Value("${redis.host}")
    String redisDataSource;

    @Value("${redis.port}")
    int redisDsPort;

    @Value("${redis.password}")
    String redisDsPassword;

    @Bean
    public LettuceConnectionFactory lettuceRedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration =
                new RedisStandaloneConfiguration(redisDataSource, redisDsPort);
        redisStandaloneConfiguration.setPassword(redisDsPassword);
        LettuceConnectionFactory lettuceRedisConnectionFactory= new LettuceConnectionFactory(redisStandaloneConfiguration);
        return lettuceRedisConnectionFactory;
    }

    @Bean
    RedisTemplate<String, Object>  redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(lettuceRedisConnectionFactory());
        return redisTemplate;
    }

}
