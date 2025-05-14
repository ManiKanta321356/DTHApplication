package com.aurum.www.DTHApplication.repo;

import com.aurum.www.DTHApplication.entity.CustomerProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerProfileRepo extends MongoRepository<CustomerProfile,Integer> {
}
