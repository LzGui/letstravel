package com.letstravel.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.letstravel.pagamento.entity.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
