package com.flickfinder.controller;

import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Person;
import io.javalin.http.Context;
import com.flickfinder.model.Movie;


import java.sql.SQLException;
import java.util.List;

public class PersonController {


    private final PersonDAO personDAO;

    public PersonController() {
        this.personDAO = new PersonDAO();
    }

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public void getAllPeople(Context ctx) throws SQLException {
        List<Person> people = personDAO.getAllPeople();
        ctx.json(people);
    }

    public void getPersonById(Context ctx) throws SQLException {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Person person = personDAO.getPersonById(id);

        if (person != null) {
            ctx.json(person);
        } else {
            ctx.status(404).result("Person not found");
        }
    }


    public void getMoviesStarringPerson(Context ctx) {
        int personId = Integer.parseInt(ctx.pathParam("id"));
        try {
            List<Movie> movies = personDAO.getMoviesStarringPerson(personId);
            ctx.json(movies);
        } catch (SQLException e) {
            ctx.status(500).result("Database error");
            e.printStackTrace();
        }
    }
}

