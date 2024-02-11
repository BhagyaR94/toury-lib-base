package com.toury.libcore.config;

import com.mongodb.MongoClientException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import static com.mongodb.client.model.Filters.eq;


@Configuration
@Slf4j
@ConfigurationProperties(prefix="spring.datasource")
public class MongoDbConfig {

//    @Value("${mongodb.username}")
    private String userName;

//    @Value("${mongodb.password}")
    private String password;

//    @Value("${mongodb.host}")
    private String host;

    private static final String CONNECTION_STRING = "mongodb+srv://bhagyaprfeb23:SACi9ItCVws0rQDh@cluster0.crzd1jf.mongodb.net/?retryWrites=true&w=majority";

    @Bean
    public MongoClient getMongoDbConnection() {
        log.info("Attempting database connection! user: {} host:{} pw:{}", userName, host, password);
        MongoClient mongoClient;
        try {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            log.info("Connected to MongoDB!");
//            MongoDatabase database = mongoClient.getDatabase("database1");
//            MongoCollection<Document> collection = database.getCollection("collection1");
//            Document doc = collection.find(eq("Title", "Sigiriya")).first();
//            if (doc != null) {
//                System.out.println(doc.toJson());
//            } else {
//                System.out.println("No matching documents found.");
//            }
        } catch (Exception exception) {
            log.info("Exception Occurred Connecting to Database {}", exception.getMessage());
            throw new MongoClientException("Unable to Connect to Database!");
        }
        return mongoClient;
    }
}
