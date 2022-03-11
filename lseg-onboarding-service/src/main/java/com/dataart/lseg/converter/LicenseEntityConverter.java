package com.dataart.lseg.converter;

import com.dataart.lseg.controller.LicenseCreateRequest;
import com.dataart.lseg.controller.UpdateLicenseRequest;
import com.dataart.lseg.dto.License;
import com.dataart.lseg.dto.Meta;
import com.dataart.lseg.entity.LicenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.IdGenerator;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class LicenseEntityConverter {

    private final IdGenerator idGenerator;

    public LicenseEntity toCreateEntity(LicenseCreateRequest request) {
        LicenseEntity licenseEntity = new LicenseEntity();
        licenseEntity.setId(idGenerator.generateId());
        licenseEntity.setName(request.getName());
        licenseEntity.setName(request.getData());
        return licenseEntity;
    }

    public License toDto(LicenseEntity licenseEntity) {
        Map<String, UUID> id = Collections.singletonMap("id", licenseEntity.getId());
        Map<String, String> name = Collections.singletonMap("name", licenseEntity.getName());
        Meta meta = new Meta(id, name);

        return License.builder()
                .meta(Collections.singletonMap("meta", meta))
                .data(Collections.singletonMap("data", licenseEntity.getData()))
                .build();
    }

    public LicenseEntity toUpdateEntity(LicenseEntity licenseEntity, UpdateLicenseRequest request) {
        licenseEntity.setName(request.getName());
        licenseEntity.setData(request.getData());
        return licenseEntity;
    }

    public List<License> toDtoList(Collection<LicenseEntity> entityList) {
        if (entityList == null) {
            return List.of();
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
