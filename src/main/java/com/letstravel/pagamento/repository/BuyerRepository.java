package com.letstravel.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.letstravel.pagamento.entity.Buyer;

@Repository
public interface BuyerRepository extends MongoRepository<Buyer, String>{

}
