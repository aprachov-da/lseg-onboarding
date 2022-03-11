package com.dataart.lseg.service;

import com.dataart.lseg.controller.LicenseCreateRequest;
import com.dataart.lseg.controller.UpdateLicenseRequest;
import com.dataart.lseg.converter.LicenseEntityConverter;
import com.dataart.lseg.dto.License;
import com.dataart.lseg.entity.LicenseEntity;
import com.dataart.lseg.exception.LicenseNotFoundException;
import com.dataart.lseg.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class LicenseService {

    private final LicenseRepository licenseRepository;
    private final LicenseEntityConverter licenseEntityConverter;

    public ResponseEntity<UUID> createLicense(LicenseCreateRequest request) {
        LicenseEntity licenseEntity = licenseEntityConverter.toCreateEntity(request);
        licenseRepository.save(licenseEntity);
        return new ResponseEntity<>(licenseEntity.getId(), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<HttpStatus> deleteLicense(UUID licenseId) {
        licenseRepository.delete(licenseRepository.getById(licenseId));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    public ResponseEntity<HttpStatus> deleteLicenses() {
        licenseRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Transactional
    public ResponseEntity<HttpStatus> updateLicense(UUID licenseId, UpdateLicenseRequest request) {
        LicenseEntity licenseEntity = getLicenseEntity(licenseId);
        licenseRepository.save(licenseEntityConverter.toUpdateEntity(licenseEntity, request));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<License> getLicense(UUID licenseId) {
        License license = licenseEntityConverter.toDto(getLicenseEntity(licenseId));
        return new ResponseEntity<>(license, HttpStatus.OK);
    }

    public ResponseEntity<List<License>> getLicenses() {
        List<License> licenses = licenseEntityConverter.toDtoList(licenseRepository.findAll());
        return new ResponseEntity<>(licenses, HttpStatus.OK);
    }

    private LicenseEntity getLicenseEntity(UUID licenseId) {
        return licenseRepository.findById(licenseId).orElseThrow(
                () -> new LicenseNotFoundException(licenseId));
    }
}
