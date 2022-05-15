package com.example.mailnotification.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTypeRepository extends CrudRepository<ServiceTypeEntity, Long> {
    ServiceTypeEntity getServiceTypeEntityByCode(String paymentTypeCode);
}