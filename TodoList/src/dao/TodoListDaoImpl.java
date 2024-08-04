package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import dto.TodoList;

public class TodoListDaoImpl implements TodoListDao{
private final String FILE_PATH = "io_test/TodoList.dat";
	
	private List<TodoList> TodoListList = null;
	
	private ObjectInputStream ois = null;
	private ObjectOutputStream oos = null;
	
	public TodoListDaoImpl() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File(FILE_PATH);
		
		if(file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(FILE_PATH)); 
				TodoListList = (ArrayList<TodoList>)ois.readObject();
			}finally {
				if(ois != null) ois.close();
			}
		}
		else {
			TodoListList = new ArrayList<TodoList>();
		}
	}
	
	
}
