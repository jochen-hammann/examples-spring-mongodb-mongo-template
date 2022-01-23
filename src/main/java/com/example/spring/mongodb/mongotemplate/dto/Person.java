package com.example.spring.mongodb.mongotemplate.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "st-person")
public class Person
{
    // ============================== [Fields] ==============================

    // -------------------- [Private Fields] --------------------

    private String id;
    private String name;
    private int age;

    // ============================== [Construction / Destruction] ==============================

    // -------------------- [Public Construction / Destruction] --------------------

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    // ============================== [Getter/Setter] ==============================

    // -------------------- [Private Getter/Setter] --------------------

    // -------------------- [Public Getter/Setter] --------------------

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    // ============================== [Methods] ==============================

    // -------------------- [Private Methods] --------------------

    // -------------------- [Public Methods] --------------------

    @Override
    public String toString()
    {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
