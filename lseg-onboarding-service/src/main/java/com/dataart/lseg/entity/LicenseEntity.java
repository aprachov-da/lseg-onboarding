package com.dataart.lseg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LicenseEntity implements Serializable {
    private UUID id;
    private String name;
    private String data;
}
