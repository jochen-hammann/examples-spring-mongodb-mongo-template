package com.example.spring.mongodb.mongotemplate.config;

import com.mongodb.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    // ============================== [Beans] ==============================

    // -------------------- [Public Beans] --------------------

    // The following bean ist required by the MongoDatabaseFactoryDependentConfiguration. If the method name is not mongoTemplate(),
    // the @Primary annotation is required. See next (commented) bean specification.
    @Bean
    public MongoTemplate mongoTemplate(MongoClient mongoClient)
    {
        return new MongoTemplate(mongoClient, "default");
    }

    // This @Primary bean is required by the MongoDatabaseFactoryDependentConfiguration, if no bean with the name mongoTemplate() exists.
    @Bean
    @Primary
    public MongoTemplate defaultMongoTemplate(MongoClient mongoClient)
    {
        return new MongoTemplate(mongoClient, "default");
    }

    // Caution: To change the database name, the following @Bean specifications can be used.

    @Bean
    public MongoTemplate mongoTemplateTestDatabase(MongoClient mongoClient)
    {
        return new MongoTemplate(mongoClient, "test");
    }

    @Bean
    public MongoTemplate mongoTemplateFoobarDatabase(MongoClient mongoClient)
    {
        return new MongoTemplate(mongoClient, "foobar");
    }

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

}
