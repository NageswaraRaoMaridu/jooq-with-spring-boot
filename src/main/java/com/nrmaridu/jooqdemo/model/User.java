package com.nrmaridu.jooqdemo.model;

import java.util.UUID;

/**
 * @author nrmaridu on 5/2/2019
 */
public class User {

    private final UUID id;
    private final String name;
    private final int age;
    private final String occupation;

    public User(UUID id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }
}
