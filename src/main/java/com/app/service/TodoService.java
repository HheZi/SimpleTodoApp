package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Todo;
import com.app.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public List<Todo> getAllTodos(){
		return repository.findAll();
	}
	
	public Todo saveTodo(Todo todo) {
		return repository.save(todo);
		
	}
	
	public void deleteTodo(Integer id) {
		repository.deleteById(id);
	}
	
}
