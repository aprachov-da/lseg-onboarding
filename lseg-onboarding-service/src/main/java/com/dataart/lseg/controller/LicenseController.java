package com.dataart.lseg.controller;

import com.dataart.lseg.dto.License;
import com.dataart.lseg.service.LicenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/v1/licenses", produces = MediaType.APPLICATION_JSON_VALUE)
public class LicenseController {

    private final LicenseService licenseService;

    @PostMapping
    public ResponseEntity<UUID> createLicense(@RequestBody LicenseCreateRequest request) {
        return licenseService.createLicense(request);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteLicense(@PathVariable("licenseId") UUID licenseId) {
        return licenseService.deleteLicense(licenseId);
    }

    @PutMapping("/{licenseId}")
    public ResponseEntity<HttpStatus> updateLicense(@PathVariable("licenseId") UUID licenseId,
                                                    @RequestBody UpdateLicenseRequest request) {
        return licenseService.updateLicense(licenseId, request);
    }

    @PostMapping("/lock/{licenseId}")
    public ResponseEntity<HttpStatus> lockLicense(@PathVariable("licenseId") UUID licenseId) {
        return licenseService.lockLicense(licenseId);
    }

    @GetMapping("/{licenseId}")
    public ResponseEntity<License> getLicense(@PathVariable("licenseId") UUID licenseId) {
        return licenseService.getLicense(licenseId);
    }

    @GetMapping
    public ResponseEntity<List<License>> getLicenses() {
        return licenseService.getLicenses();
    }
}
