package com.example.spring.mongodb.mongotemplate;

import com.example.spring.mongodb.mongotemplate.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Update.update;

@SpringBootApplication
public class MongoTemplateApplication implements CommandLineRunner
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    Logger logger = LoggerFactory.getLogger(MongoTemplateApplication.class);

    @Autowired
    @Qualifier("mongoTemplateTestDatabase")
    private MongoTemplate mongoTemplate;

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    public static void main(String[] args)
    {
        SpringApplication.run(MongoTemplateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        Person person = new Person("Joe", 34);

        // Insert is used to initially store the object into the database.
        mongoTemplate.insert(person);
        logger.info("Insert: " + person);

        // Find
        person = mongoTemplate.findById(person.getId(), Person.class);
        logger.info("Found: " + person);

        // Update
        mongoTemplate.updateFirst(query(where("name").is("Joe")), update("age", 35), Person.class);
        person = mongoTemplate.findOne(query(where("name").is("Joe")), Person.class);
        logger.info("Updated: " + person);

        // Delete
        mongoTemplate.remove(person);

        // Check that deletion worked
        List<Person> people = mongoTemplate.findAll(Person.class);
        logger.info("Number of people = : " + people.size());

        // Drop the collection.
        mongoTemplate.dropCollection(Person.class);
    }
}
