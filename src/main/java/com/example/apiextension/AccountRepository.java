package com.example.apiextension;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountPOJO, String> {


}
