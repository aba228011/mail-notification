package com.example.mailnotification.model;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends ElasticsearchRepository<ClientEntity, String> {
    ClientEntity getClientEntityByClientId(String clientId);
}
