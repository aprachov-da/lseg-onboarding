package com.dataart.lseg.repository;

import com.dataart.lseg.entity.LicenseEntity;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LicenseRepository {
    public static final String LICENSE = "License";
    private HashOperations hashOperations;
    private RedisTemplate redisTemplate;

    public LicenseRepository(RedisTemplate redisTemplate) {
        this.hashOperations = redisTemplate.opsForHash();
        this.redisTemplate = redisTemplate;
    }

    public void save(LicenseEntity licenseEntity) {
        hashOperations.put(LICENSE, licenseEntity.getId(), licenseEntity);
    }

    public List<LicenseEntity> findAll() {
        return hashOperations.values(LICENSE);
    }

    public LicenseEntity findById(UUID id) {
        return (LicenseEntity) hashOperations.get(LICENSE, id);
    }

    public void update(LicenseEntity licenseEntity) {
        save(licenseEntity);
    }

    public void delete(UUID licenseId) {
        hashOperations.delete(LICENSE, licenseId);
    }
}
