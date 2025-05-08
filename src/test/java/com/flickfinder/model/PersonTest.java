package com.flickfinder.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testConstructorAndGetters() {
        Person person = new Person(1, "Muneer Nawaf", 1978);
        assertEquals(1, person.getId());
        assertEquals("Muneer Nawaf", person.getName());
        assertEquals(1978, person.getBirth());
    }

    @Test
    public void testSetters() {
        Person person = new Person();
        person.setId(2);
        person.setName("Bobby Samir");
        person.setBirth(1972);

        assertEquals(2, person.getId());
        assertEquals("Bobby Samir", person.getName());
        assertEquals(1972, person.getBirth());
    }

    @Test
    public void testToString() {
        Person person = new Person(3, "John Wick", 1980);
        assertEquals("3|John Wick|1980", person.toString());
    }
}