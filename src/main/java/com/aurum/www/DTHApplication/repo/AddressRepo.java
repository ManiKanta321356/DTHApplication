package com.aurum.www.DTHApplication.repo;

import com.aurum.www.DTHApplication.entity.Address;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends MongoRepository<Address,Integer> {
}
