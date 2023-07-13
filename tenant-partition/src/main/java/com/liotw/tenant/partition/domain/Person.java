package com.liotw.tenant.partition.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


import org.hibernate.annotations.TenantId;

/**
 * Person Domain
 *
 * @author jjl
 * @date 2023/7/12
 */
@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @TenantId
    private String tenantId;
    private String name;
    private Integer age;
}

