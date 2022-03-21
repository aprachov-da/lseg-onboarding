package com.dataart.lseg.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class LockLicenseRequest {
    private boolean lock;
}
