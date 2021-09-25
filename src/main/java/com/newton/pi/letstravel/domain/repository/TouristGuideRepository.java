package com.newton.pi.letstravel.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.newton.pi.letstravel.domain.entity.TouristGuide;

public interface TouristGuideRepository extends MongoRepository<TouristGuide, String> {

}
