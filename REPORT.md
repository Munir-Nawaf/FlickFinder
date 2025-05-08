# COM1008 - Software Engineering


[Lines in square brackets are placeholders or instructions; you should replace them with the appropriate information. Please ensure no placeholder text is left in the final version (including this line, and the Lines below).]

[As this is a markdown file, you should edit it in a IDE or text editor that supports markdown - don't use Microsoft Word or other word processors. For more information on markdown, see: https://www.markdownguide.org/]

[** Before you submit, preview the rendered version of the file to ensure it is formatted correctly. Gitlab will render the markdown file as HTML, so please check the output is correct. Also, you can use an IDE or text editor that supports markdown to preview the file (e.g., VSCode). ** ] 

# Assignment 1 - Report

**Student Name: Muneer Dheyaa Nawaf**

**Student ID: mn01236**

## 1.1 Proto Personas

### Persona 1

 ** First Year CS Student with Limited time**

Muneer is 19 and studying Computer Science at the University of Surrey.
With part-time working, course work, and attending lectures, he has no time to surf pointlessly.
He primarily employs FlickFinder to rapidly look up cast information or verify when a film was released.
When he does get time off, he enjoys finding lesser-known older films and appreciates apps that allow him to
easily find something new without having to work hard at it.
He likes clean design, fast search, and concise descriptions.

### Persona 2

** Comedy Loving Casual Viewer**

Alaa Nawaf is a 24-year-old freelance graphic designer who enjoys relaxing with entertainment following a working day.
He primarily watches comedy films and programs on television or free internet streaming.
Alaa is not very tech-friendly, so he prefers clean, simple interfaces that don't require logging in or account setup.
His largest source of frustration is having too many options and being swamped by them or needing to subscribe first to watch content.
All he wants is to easily locate something amusing to watch and relax.


## 1.2 Scenario

** Discovering Comedy Movies**

Manar has just returned from the office after a long day of work and wants to relax by watching a comedy movie.
She remembers hearing about a comedy movie sometime in the late 90s but does not know the name.
She opens the FlickFinder app, filters by genre and year of release, and receives a list of movies from 1999 within seconds.
After reading a few titles, she finds one that catches her interest and decides to watch it on her laptop.

## 1.3 User Stories

### User Story 1

** Quick Movie Lookup **

As a student with limited free time,
I want to quickly search for a movie by title,
so I can get the general information without any distraction.

### User Story 2

** Discover Films by Year **

As someone who likes old films,
I'd like to be able to search for films by release date,
so I can see movies from a specific period.

### User Story 3

** View Movie Cast **

As a user who checks cast info frequently,
I want to view a list of people who starred in a movie,
so I can recognize familiar actors.

### User Story 4

** Simple Browsing Without Accounts **

As a casual user,
I would like to browse and use the app without registering for an account,
so I can get started right away without hassle.

### User Story 5

** Find Something Funny Quickly**

As a comedy fan,
I'd like to filter movies by genre,
so I can quickly find something funny to watch.

### User Story 6

** Keep It Simple and Easy **

As a non-technical user,
I'd like a simple interface with clear buttons
so I won't be confused using the app.

## 2 Critical Analysis and Reflection

### 2.1 Reflection

Throughout this project, I was able to incrementally build the backend for FlickFinder using Java, Javalin, and SQLite.
Creating the Movie and Person models and their corresponding DAOs and controllers taught me that separation of logic makes the code easier to maintain.

Creating the /movies/{id}/stars and /people/{id}/movies routes was one of the more challenging tasks, requiring joins and how to map relationships between models.
I still struggled with tying controller logic to DAO queries, especially combining the results without the initial tables like people and movies.
Debugging SQL queries and an understanding of how Javalin routes required experimentation.

Overall, I’m proud of getting all required endpoints working and tested.
This project improved my confidence in backend development and clarified how to handle database operations in Java.

### 2.2 Professional Aspects

Something I definitely caught on to while completing this project is how much structure plays a part in programming.
Dividing it all up into models, DAOs, and controllers felt like overkill initially but the more the application expanded, I could see how much simpler it was to work with and alter without having to break something.
I can understand now why this kind of separation is such a big deal in the industry.

I also tried harder to make sure how the app interacts with the user. I tried to send correct status codes like 404 if something didn't exist or 500 if the database encountered an error.
Before this project, I didn't really think about that. I just wanted the app to "work"  but now I know it's a question of making clean stable APIs.

Testing was the next challenge. Writing JUnit and Mockito tests had seemed unnatural initially, especially the mocking the controller kind of things, but it really made me feel that much more confident the big pieces of the app were solid.
I didn't get everything perfect, but I have an idea now why profesional developers are so picky about testing.

I also tried to think about the end user, especially when establishing the user stories and paths.
I aimed to keep things simple — clear, straightforward endpoints that a real user would naturally expect.
That line of thinking drove much of my decisions along the way.


## 3. References

None. I used knowledge from the COM1028 course materials with personal understanding.
