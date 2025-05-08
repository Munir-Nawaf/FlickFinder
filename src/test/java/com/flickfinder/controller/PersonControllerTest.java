package com.flickfinder.controller;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Person;
import io.javalin.http.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class PersonControllerTest {

    private PersonDAO mockPersonDAO;
    private PersonController personController;
    private Context mockCtx;

    @BeforeEach
    public void setup() {
        mockPersonDAO = mock(PersonDAO.class);        // Fake DAO
        personController = new PersonController(mockPersonDAO);  // Inject it
        mockCtx = mock(Context.class);                // Fake HTTP context
    }

    @Test
    public void testGetAllPeople() throws SQLException {
        List<Person> mockPeople = Arrays.asList(
                new Person(1, "Alice", 1970),
                new Person(2, "Bob", 1980)
        );

        when(mockPersonDAO.getAllPeople()).thenReturn(mockPeople);
        personController.getAllPeople(mockCtx);

        verify(mockCtx).json(mockPeople);
    }

    @Test
    public void testGetPersonById_Found() throws SQLException {
        when(mockCtx.pathParam("id")).thenReturn("1");
        Person person = new Person(1, "Alice", 1970);
        when(mockPersonDAO.getPersonById(1)).thenReturn(person);

        personController.getPersonById(mockCtx);

        verify(mockCtx).json(person);
    }

    @Test
    public void testGetPersonById_NotFound() throws SQLException {
        when(mockCtx.pathParam("id")).thenReturn("999");
        when(mockPersonDAO.getPersonById(999)).thenReturn(null);
        when(mockCtx.status(404)).thenReturn(mockCtx); // fix
        when(mockCtx.result("Person not found")).thenReturn(mockCtx); // optional, if chained

        personController.getPersonById(mockCtx);

        verify(mockCtx).status(404);
        verify(mockCtx).result("Person not found");
    }
}