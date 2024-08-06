package service;

import java.io.IOException;
import java.util.List;

import dto.Todo;



public interface TodoListService {
	
	
	public abstract	List<Todo> getTodoList();

	
	public abstract boolean addTodoList(String title, String detail) throws IOException;


	List<Todo> selectTitle(String searchTitle);

	public List<Todo> selectIndex(int input) ;


	String removeMember(int input) throws IOException;

}
