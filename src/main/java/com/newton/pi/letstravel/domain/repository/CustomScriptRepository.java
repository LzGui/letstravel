package com.newton.pi.letstravel.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.newton.pi.letstravel.domain.entity.CustomScript;


public interface CustomScriptRepository extends MongoRepository<CustomScript, String> {

}