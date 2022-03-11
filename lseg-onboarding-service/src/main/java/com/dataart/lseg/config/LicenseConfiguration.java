package com.dataart.lseg.config;

import com.dataart.lseg.converter.LicenseEntityConverter;
import com.dataart.lseg.repository.LicenseRepository;
import com.dataart.lseg.service.LicenseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

//    @Bean
//    public LettuceConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("server", 6379));
//    }
}
