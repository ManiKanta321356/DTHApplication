package com.aurum.www.DTHApplication.repo;

import com.aurum.www.DTHApplication.entity.SetupBox;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetupBoxRepo extends MongoRepository<SetupBox,Integer> {

}
