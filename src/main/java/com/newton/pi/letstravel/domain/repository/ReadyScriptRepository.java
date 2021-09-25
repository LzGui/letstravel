package com.newton.pi.letstravel.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.newton.pi.letstravel.domain.entity.ReadyScript;


public interface ReadyScriptRepository extends MongoRepository<ReadyScript, String> {

}
