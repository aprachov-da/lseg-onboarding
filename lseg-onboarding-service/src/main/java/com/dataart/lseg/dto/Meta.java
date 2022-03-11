package com.dataart.lseg.dto;

import lombok.Value;

import java.util.Map;
import java.util.UUID;

@Value
public class Meta {
    Map<String, UUID> id;
    Map<String, String> name;
}
