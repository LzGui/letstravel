package com.letstravel.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.letstravel.pagamento.entity.Card;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

}
