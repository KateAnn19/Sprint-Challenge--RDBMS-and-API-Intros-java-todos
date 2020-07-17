package com.lambdaschool.todos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Main class to start the application.
 */
@EnableJpaAuditing
@SpringBootApplication
public class TodosApplication
{

    /**
     * Main method to start the application.
     *
     * @param args Not used in this application.
     */
    public static void main(String[] args)
    {
        SpringApplication.run(TodosApplication.class,
            args);
    }
}


    /*

    1) Can you explain your data model, data schema to me?

    *********There are two tables, a todos table and a user table. The todos table has a many to one relationship
    with user and user has a many to one relationships with todos. The todos has a todoid, description and completed field plus it
    has a user attached to a todo (there are no todos without users).
    All todos default to not completed. Users has a username, password and primary email and a list of todos.

    Users is our primary table because without users there are no todos.

    2) Can you explain how you connected your API to a database?
    ********** You connect the API using the CRUD Repository



   3) Can you explain the flow of data from client through the backend system and back to the client?
    ********** Client sends a new request using an endpoint that calls methods in services which calls
    the repositories which connects to our table. When we start our application this also starts Jackson which
    waits for a new request. One the data is gathered it is sent back to our controllers which sends the data
    back to the client.


    4) How did you handle querying in your application: custom querying vs JPA Querying?
    Custom query works by connecting to SQL. We write a custom query which will be connected to the database by
    an interface which contains method headers that connect the SQL. JPA querying is handled for us and
    we do not need to write custom queries. We get some queries for free through the JPA. 
    **********
    */

