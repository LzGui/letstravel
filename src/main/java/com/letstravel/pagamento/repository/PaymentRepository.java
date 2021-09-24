package com.letstravel.pagamento.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.letstravel.pagamento.entity.Payment;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, String>{

}
