package com.dataart.lseg.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
@NoArgsConstructor
public class UpdateLicenseRequest {
    protected String name;
    protected String data;
}
