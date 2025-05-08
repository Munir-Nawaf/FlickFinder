package com.flickfinder.controller;

import java.sql.SQLException;
import java.util.List;

import com.flickfinder.dao.MovieDAO;
import com.flickfinder.dao.PersonDAO;
import com.flickfinder.model.Movie;
import com.flickfinder.model.Person;

import io.javalin.http.Context;

/**
 * The controller for the movie endpoints.
 */
public class MovieController {

	private final MovieDAO movieDAO;
	private final PersonDAO personDAO;

	/**
	 * Constructs a MovieController object with both DAOs.
	 */
	public MovieController(MovieDAO movieDAO, PersonDAO personDAO) {
		this.movieDAO = movieDAO;
		this.personDAO = personDAO;
	}

	/**
	 * Returns a list of all movies in the database.
	 */
	public void getAllMovies(Context ctx) {
		try {
			ctx.json(movieDAO.getAllMovies());
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}

	/**
	 * Returns the movie with the specified id.
	 */
	public void getMovieById(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		try {
			Movie movie = movieDAO.getMovieById(id);
			if (movie == null) {
				ctx.status(404).result("Movie not found");
				return;
			}
			ctx.json(movie);
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}

	/**
	 * Returns all people who starred in a movie.
	 */
	public void getPeopleByMovieId(Context ctx) {
		int movieId = Integer.parseInt(ctx.pathParam("id"));
		try {
			List<Person> people = personDAO.getPeopleByMovieId(movieId);
			ctx.json(people);
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}

	public void getRatingsByYear(Context ctx) {
		int year = Integer.parseInt(ctx.pathParam("year"));
		try {
			ctx.json(movieDAO.getRatingsByYear(year));
		} catch (SQLException e) {
			ctx.status(500).result("Database error");
			e.printStackTrace();
		}
	}
}