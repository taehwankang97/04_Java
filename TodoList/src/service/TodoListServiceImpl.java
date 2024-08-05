package service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import dao.TodoListDao;
import dao.TodoListDaoImpl;
import dto.Todo;

public class TodoListServiceImpl implements TodoListService {

    private TodoListDao dao = null;
    private boolean complete = false;

    public TodoListServiceImpl() throws IOException, ClassNotFoundException {
        dao = new TodoListDaoImpl();
    }

    @Override
    public List<Todo> getTodoList() {
        return dao.getTodoList();
    }

    @Override
    public boolean addTodoList(String title, String detail) throws IOException {
        List<Todo> todoList = dao.getTodoList();

        for (Todo todo : todoList) {
            if (detail.equals(todo.getDetail())) {
                return false; // 이미 존재하는 세부사항
            }
        }

        Todo todo = new Todo(title, detail, complete, LocalDateTime.now());
        boolean result = dao.addTodo(todo);
        return result;
    }

    @Override
    public List<Todo> selectTitle(String searchTitle) {
        List<Todo> todoList = dao.getTodoList();
        return todoList.stream()
                       .filter(todo -> todo.getTitle().equalsIgnoreCase(searchTitle))
                       .toList();
    }

    @Override
    public boolean addTodo(Todo todo) throws IOException {
        return dao.addTodo(todo);
    }
}
