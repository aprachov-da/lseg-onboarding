package com.dataart.lseg.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "licenses")
@NoArgsConstructor
public class LicenseEntity {
    @Id
    @Column(name = "license_id")
    @EqualsAndHashCode.Include
    private UUID id;

    private String name;

    private String data;
}
