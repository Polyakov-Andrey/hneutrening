package com.rozdolskyi.traininghneu.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.DB;
import com.mongodb.MongoException;
import com.mongodb.MongoURI;

@Configuration
public class SpringConfig {

    @Bean
    public DB getDb() throws UnknownHostException, MongoException {
        MongoURI mongoURI = new MongoURI("mongodb://rozodlski:Rozdolski1994@ds055915.mongolab.com:55915/heroku_b9wf13wr");
        System.out.println("==================================" + mongoURI.getUsername());
        DB db = mongoURI.connectDB();
        db.authenticate(mongoURI.getUsername(), mongoURI.getPassword());
        return db;
    }
}
