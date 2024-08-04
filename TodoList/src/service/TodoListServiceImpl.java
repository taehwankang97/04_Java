package service;

import java.io.FileNotFoundException;
import java.io.IOException;

import dao.TodoListDao;
import dao.TodoListDaoImpl;

public class TodoListServiceImpl implements TodoListService {
private TodoListDao dao = null;
	
	public TodoListServiceImpl() throws FileNotFoundException, ClassNotFoundException, IOException {
		dao = new TodoListDaoImpl();
	}
}
