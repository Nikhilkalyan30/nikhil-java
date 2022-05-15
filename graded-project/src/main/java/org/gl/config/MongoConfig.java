
package org.gl.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@ComponentScan("org.gl")
@EnableMongoRepositories(basePackages = "org.gl.repository")
public class MongoConfig extends AbstractMongoClientConfiguration{

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/test");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
            .applyConnectionString(connectionString)
            .build();
        
        return MongoClients.create(mongoClientSettings);
	}
	
	
	@Override
	protected Collection getMappingBasePackages() {
		// TODO Auto-generated method stub
		return Collections.singleton("com.baeldung");

	}
	
	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "test8";
	}
	
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		
		return new PersistenceExceptionTranslationPostProcessor();
	}
	
	
	
	
	
}