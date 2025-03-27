package com.todo.todoApp.model;
import jakarta.persistence.*;

@Entity // Indica que esta clase es una entidad, las entidades son objetos persistentes que se almacenan en la base de datos 
@Table(name = "todos") // Indica que la entidad se debe almacenar en la tabla "todos"
public class Todo {
  @Id // Indica que la columna "id" es la clave primaria de la entidad
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que la columna "id" se debe generar automáticamente
  private Long id;

  private String title;
  private boolean completed;

  public Todo() {
  }

  public Todo(String title, boolean completed) {
    this.title = title;
    this.completed = completed;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean done) {
    this.completed = done;
  }
}
