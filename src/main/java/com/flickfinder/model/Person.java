package com.flickfinder.model;

/**
 * A person in the movie database.
 * 
 * @TODO: Implement this class
 */

        //Done
public class Person {

    private int id;
    private String name;
    private int birth;

    public Person() {
        super();
    }

    public Person(int id, String name, int birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    // getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBirth() {
        return birth;
    }


    //setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(int birth) {
        this.birth = birth;
    }


    public String toString() {
        return id + "|" + name + "|" + birth;
    }
}


