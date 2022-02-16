package com.br.jborba.bahamasclient.adapters.configuration.persistence;

import com.br.jborba.bahamasclient.adapters.persistence.mongo.MongoClientRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = MongoClientRepository.class)
public class MongoDBConfiguration {
}
