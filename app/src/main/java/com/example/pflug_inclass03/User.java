/*
 * Assignment #: InClass 03
 * File Name: Pflug_InClass03 --- User.java
 * Full Name: Kristin Pflug
 */

package com.example.pflug_inclass03;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    String email;
    int id;
    String department;

    public User(String name, String email, int id, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
    }


}
