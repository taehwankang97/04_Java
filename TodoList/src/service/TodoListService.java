package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;



public interface TodoListService {
	
	
	public abstract	List<Todo> getTodoList();

	
	boolean addTodoList(String title, String detail) throws IOException;

	boolean addTodo(Todo todo) throws IOException;

	List<Todo> selectTitle(String searchTitle);
	

}
