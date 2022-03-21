package com.dataart.lseg.config;

import com.dataart.lseg.converter.LicenseEntityConverter;
import com.dataart.lseg.messaging.MessagePublisher;
import com.dataart.lseg.messaging.RedisMessagePublisher;
import com.dataart.lseg.messaging.RedisMessageSubscriber;
import com.dataart.lseg.repository.LicenseRepository;
import com.dataart.lseg.service.LicenseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.util.IdGenerator;
import org.springframework.util.JdkIdGenerator;

@Configuration
public class LicenseConfiguration {

    @Bean
    public LicenseEntityConverter licenseEntityConverter(IdGenerator idGenerator) {
        return new LicenseEntityConverter(idGenerator);
    }

    @Bean
    public LicenseService licenseService(LicenseRepository licenseRepository,
                                         LicenseEntityConverter licenseEntityConverter) {
        return new LicenseService(licenseRepository, licenseEntityConverter);
    }

    @Bean
    public IdGenerator idGenerator() {
        return new JdkIdGenerator();
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(lettuceConnectionFactory());
        return redisTemplate;
    }

//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }

    @Bean
    public LettuceConnectionFactory lettuceConnectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
    }

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new RedisMessageSubscriber());
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(lettuceConnectionFactory());
        container.addMessageListener(messageListener(), topic());
        return container;
    }

    @Bean
    MessagePublisher redisPublisher() {
        return new RedisMessagePublisher(redisTemplate(), topic());
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("messageQueue");
    }
}
