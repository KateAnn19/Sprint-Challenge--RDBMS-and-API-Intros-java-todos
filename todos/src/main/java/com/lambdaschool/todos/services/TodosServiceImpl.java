package com.lambdaschool.todos.services;

import com.lambdaschool.todos.models.Todos;
import com.lambdaschool.todos.models.User;
import com.lambdaschool.todos.repository.TodosRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "todosService")
public class TodosServiceImpl implements TodosService
{


    @Autowired
    private TodosRepository todosrepos;

    @Autowired
    private UserService userService;

    @Override
    public void markComplete(long todoid)
    {
        Todos currTodo = todosrepos.findById(todoid).orElseThrow(() -> new EntityNotFoundException("Todo" + todoid + " Not Found"));

        currTodo.setCompleted(true);
    }

    @Override
    public Todos update(long id, boolean done)
    {
        return null;
    }

    @Override
    public Todos save(long userid, Todos todo)
    {
        User currentUser = userService.findUserById(userid);
        Todos newUserTodo = new Todos (currentUser, todo.getDescription());
        return todosrepos.save(newUserTodo);
    }

    @Override
    public List<Todos> findAll()
    {
        List<Todos> list = new ArrayList<>();
        todosrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Todos findTodoById(long id)
    {
        return todosrepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Todo " + id + " Not Found"));
    }
}
