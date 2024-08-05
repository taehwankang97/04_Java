package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Todo;

public class TodoListDaoImpl implements TodoListDao {

    private final String FILE_PATH = "TodoList.dat";
    private List<Todo> todoList = null;

    public TodoListDaoImpl() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);

        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                todoList = (ArrayList<Todo>) ois.readObject();
            }
        } else {
            todoList = new ArrayList<>();
        }
    }

    @Override
    public List<Todo> getTodoList() {
        return todoList;
    }

    @Override
    public boolean addTodo(Todo todo) throws IOException {
        todoList.add(todo);
        saveFile();
        return true;
    }

    @Override
    public void saveFile() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(todoList);
        }
    }
}
