package com.todo.todoApp.service;

import com.todo.todoApp.model.Todo; // Importamos la clase Todo
import com.todo.todoApp.repository.TodoRepository;// Importamos la clase TodoRepository
import org.springframework.beans.factory.annotation.Autowired; // Importamos la anotación @Autowired para inyectar la dependencia
import org.springframework.stereotype.Service; // Importamos la anotación @Service para marcar la clase como un servicio

import java.util.List; // Importamos la clase List
import java.util.Optional; // Importamos la clase Optional

@Service // Indica que esta clase es un servicio. Marca la clase como un componente de acceso a la base de datos.
public class TodoService {
  @Autowired // Inyecta la dependencia
  private TodoRepository todoRepository; // Declaramos la dependencia

  public List<Todo> getAllTodos() { // Método para obtener todos los todos
    return todoRepository.findAll(); // Llamamos al método findAll() de la clase TodoRepository
  }

  public Optional<Todo> getTodoById(Long id) { // Método para obtener un todo por su ID
    return todoRepository.findById(id); // Llamamos al método findById() de la clase TodoRepository
  }

  public Todo createTodo(Todo todo) { // Método para crear un todo
    return todoRepository.save(todo); // Llamamos al método save() de la clase TodoRepository
  }

  public Todo updateTodo(Long id, Todo newTodo) {
    return todoRepository.findById(id).map(todo -> {
        todo.setTitle(newTodo.getTitle());
        todo.setCompleted(newTodo.isCompleted());
        return todoRepository.save(todo);
    }).orElse(null);
}
  public void deleteTodo(Long id) {
    todoRepository.deleteById(id);
  }
}
