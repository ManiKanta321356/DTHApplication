package com.aurum.www.DTHApplication.repo;

import com.aurum.www.DTHApplication.entity.Registration;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepo extends MongoRepository<Registration, Integer> {
}
