package com.flickfinder.dao;
import com.flickfinder.model.Person;
import com.flickfinder.util.Database;
import com.flickfinder.model.Movie;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Implement this class
 *
 */
public class PersonDAO {
    private final Connection connection;

    public PersonDAO() {
        Database database = Database.getInstance();
        connection = database.getConnection();
    }

    public List<Person> getAllPeople() throws SQLException {
        List<Person> people = new ArrayList<>();

        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE LIMIT 50");

        while (rs.next()) {
            people.add(new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("birth")
            ));
        }

        return people;
    }

    public Person getPersonById(int id) throws SQLException {
        String sql = "SELECT * FROM PEOPLE WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            return new Person(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("birth")
            );
        }

        return null;
    }


    public List<Person> getPeopleByMovieId(int movieId) throws SQLException {
        List<Person> people = new ArrayList<>();

        String query = """
        SELECT p.id, p.name, p.birth
        FROM people p
        JOIN stars s ON p.id = s.person_id
        WHERE s.movie_id = ?
    """;

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, movieId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            people.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("birth")));
        }

        return people;
    }

    public List<Movie> getMoviesStarringPerson(int personId) throws SQLException {
        List<Movie> movies = new ArrayList<>();

        String query = """
        SELECT m.id, m.title, m.year
        FROM movies m
        JOIN stars s ON m.id = s.movie_id
        WHERE s.person_id = ?
    """;

        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, personId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            movies.add(new Movie(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("year")
            ));
        }

        return movies;
    }
}




    // for the must have requirements, you will need to implement the following
	// methods:
	// - getAllPeople()
	// - getPersonById(int id)
	// you will add further methods for the more advanced tasks; however, ensure your have completed 
	// the must have requirements before you start these.  


