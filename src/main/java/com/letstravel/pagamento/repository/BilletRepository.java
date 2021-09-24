package com.letstravel.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.letstravel.pagamento.entity.Billet;

@Repository
public interface BilletRepository extends MongoRepository<Billet, String>{

}
