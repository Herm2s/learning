package com.hermes.others.streamex;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {
    int id;
    String name;
    Role role = new Role();

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}