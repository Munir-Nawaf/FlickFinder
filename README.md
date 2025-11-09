# FlickFinder 🎬  
A REST API for exploring movie data, built with **Java**, **Javalin**, and **SQLite**.

FlickFinder provides endpoints to browse movies, view details, and discover cast members.  
It demonstrates clean backend architecture with Models, Controllers, and DAOs.

---

## 🚀 Features
- Search movies by ID or title
- View full movie details
- Look up actors and directors
- View all movies a person appears in
- REST-style JSON responses

---

## 🧱 Tech Stack
| Layer       | Technology |
|------------|------------|
| Language    | Java 17    |
| Web Server  | Javalin    |
| Database    | SQLite     |
| Testing     | JUnit + Mockito |
| Build Tool  | Maven      |

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/movies` | List all movies |
| GET | `/movies/{id}` | Get movie by ID |
| GET | `/movies/{id}/stars` | Get actors in a movie |
| GET | `/people/{id}` | Get person by ID |
| GET | `/people/{id}/movies` | Get all movies a person appears in |



## 🧠 What I Learned
- Designing and building REST APIs
- SQL querying and data retrieval
- clean separation of Model, DAO, Controller layers
- Testing backend logic with JUnit & Mockito

---

