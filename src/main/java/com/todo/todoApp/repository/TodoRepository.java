package com.todo.todoApp.repository;

import com.todo.todoApp.model.Todo; // Importamos la clase Todo
import org.springframework.data.jpa.repository.JpaRepository; // Importamos la anotación @JpaRepository
import org.springframework.stereotype.Repository; // Importamos la anotación @Repository
import java.util.List; // Importamos la clase List

@Repository // Indica que esta clase es un repositorio. Marca la clase como un componente de acceso a la base de datos.
public interface TodoRepository extends JpaRepository<Todo, Long> { // Le dice a Spring Boot que maneje la entidad Todo con Long como ID, Declaramos que esta clase implementa la interfaz JpaRepository<Todo, Long>
  List<Todo> findByCompleted(boolean completed);
}
