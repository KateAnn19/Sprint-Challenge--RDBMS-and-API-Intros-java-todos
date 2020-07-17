package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;

import java.util.List;

public interface TodosService
{
    void markComplete(long todoid);

    Todos update(long id, boolean done);

    Todos save(long userid, Todos todo);

    List<Todos> findAll();

    Todos findTodoById(long id);
}
