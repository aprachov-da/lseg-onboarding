package com.dataart.lseg.dto;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
public class License {
    Map<String, Object> meta;
    Map<String, Object> data;
}
