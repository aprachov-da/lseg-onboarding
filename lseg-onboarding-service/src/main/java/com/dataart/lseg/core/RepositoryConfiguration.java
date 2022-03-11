package com.dataart.lseg.core;

import com.dataart.lseg.repository.LicenseRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = LicenseRepository.class)
public class RepositoryConfiguration {
}
