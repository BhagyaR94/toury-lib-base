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
public class MongoDbConfig {

    @Bean
    public DBProperties getDBProperties() {
        return new DBProperties();
    }

    @Bean
    public MongoClient getMongoDbConnection() {
        String CONNECTION_STRING = "mongodb+srv://" + this.getDBProperties().getUserName() + ":" + this.getDBProperties().getPassword() + "@" + this.getDBProperties().getHost() + "/?retryWrites=true&w=majority";
        log.info("Attempting database connection!");
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
