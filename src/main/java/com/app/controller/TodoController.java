package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Todo;
import com.app.service.TodoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TodoController {

	@Autowired
	private TodoService service;
	
	@GetMapping
	public String home(Model model) {
		model.addAttribute("todos", service.getAllTodos());
		return "index";
	}
	
	@PostMapping("/save")
	public String saveAndGetAgain(@ModelAttribute Todo todo, Model model) {
		service.saveTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("create")
	public String getToCreate(Model model) {
		model.addAttribute("todo", new Todo());
		return "createOrUpdate";
	}
	
	
	@GetMapping("update/{id}")
	public String getToUpdate(@PathVariable("id") Integer id, Model model) {
		model.addAttribute("todo", service.findById(id));
		return "createOrUpdate";
	}
	
	
	@GetMapping("delete/{id}")
	public String deleteAndGet(@PathVariable("id") Integer id, Model model) {
		service.deleteTodo(id);
		return "redirect:/";
	}
	
}
