package com.flickfinder.dao;

import com.flickfinder.model.Person;
import com.flickfinder.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersonDAOTest {

    private PersonDAO personDAO;

    @BeforeEach
    public void setup() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/movies.db");
        Database.getInstance(connection);
        personDAO = new PersonDAO();
    }

    @Test
    public void testGetAllPeople() throws SQLException {
        List<Person> people = personDAO.getAllPeople();
        assertNotNull(people);
        assertFalse(people.isEmpty());
        assertTrue(people.size() <= 50);
    }

    @Test
    public void testGetPersonById_ValidId() throws SQLException {
        Person person = personDAO.getPersonById(1);  // assumes ID 1 exists
        assertNotNull(person);
        assertEquals(1, person.getId());
    }

    @Test
    public void testGetPersonById_InvalidId() throws SQLException {
        Person person = personDAO.getPersonById(-1); // unlikely to exist
        assertNull(person);
    }
}