package com.todo.todoApp.controller;

import com.todo.todoApp.model.Todo; // Importamos la clase Todo
import com.todo.todoApp.service.TodoService; // Importamos la clase TodoService
import org.springframework.beans.factory.annotation.Autowired; // Importamos la anotación @Autowired para inyectar la dependencia
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.aop.aspectj.annotation.*; // Importamos la anotación @Aspect para configurar el aspecto
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List; // Importamos la clase List
import java.util.Optional; // Importamos la clase Optional

@RestController // Indica que esta clase es un controlador REST. Marca la clase como un componente de acceso a la base de datos.
@RequestMapping("/api/todos") // Indica que la ruta de acceso es "/todos"
@CrossOrigin(origins = "*") // Permite el acceso desde cualquier origen
public class TodoController {

  @Autowired // Inyecta la dependencia
  private TodoService todoService; // Declaramos la dependencia

  @GetMapping // Indica que esta ruta se debe mapear a un método GET
  public List<Todo> getAllTodos() { // Método para obtener todos los todos
    return todoService.getAllTodos(); // Llamamos al método getAllTodos() de la clase TodoService
  }

  @GetMapping("/{id}")
  public Optional<Todo> getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

  @PostMapping
  public Todo createTodo(@RequestBody Todo todo) {
      return todoService.createTodo(todo);
  }

  @PutMapping("/{id}")
  public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
      return todoService.updateTodo(id, todo);
  }

  @DeleteMapping("/{id}")
  public void deleteTodo(@PathVariable Long id) {
      todoService.deleteTodo(id);
  }

  @DeleteMapping("/completed")
  public void deleteAllCompletedTodos() {
      todoService.deleteAllCompletedTodos();
  }
}
