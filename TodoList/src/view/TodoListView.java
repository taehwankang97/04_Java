package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.format.DateTimeFormatter;
import java.util.List;

import dto.Todo;
import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {

    private TodoListService service = null;
    private BufferedReader br = null;

    public TodoListView() {
        try {
            service = new TodoListServiceImpl();
            br = new BufferedReader(new InputStreamReader(System.in));
        } catch (Exception e) {
            System.out.println("*** 프로그램 실행 중 오류발생 ***");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private int selectMenu() throws NumberFormatException, IOException {
        System.out.println("====== Todo List =====");
        System.out.println("1. Todo List Full View");
        System.out.println("2. Todo Detail View");
        System.out.println("3. Todo Add");
        System.out.println("4. Todo Complete");
        System.out.println("5. Todo Update");
        System.out.println("6. Todo Delete");
        System.out.println("0. EXIT");

        System.out.print("select menu number >>> ");
        int input = Integer.parseInt(br.readLine());
        System.out.println();
        return input;
    }

    public void mainMenu() {
        int input = 0;

        do {
            try {
                input = selectMenu();
                switch (input) {
                    case 1:
                        TodoListFullView();
                        break;
                    case 2:
                        TodoDetailView();
                        break;
                    case 3:
                        addTodo();
                        break;
                    case 4:
                        completeTodo();
                        break;
                    case 5:
                        // updateTodo(); // Implement as needed
                        break;
                    case 6:
                        // deleteTodo(); // Implement as needed
                        break;
                    case 0:
                        System.out.println("\n@@@ 프로그램 종료 @@@\n");
                        break;
                    default:
                        System.out.println("잘못 입력하였습니다.");
                }
                System.out.println("==============================================");
            } catch (NumberFormatException e) {
                System.out.println("\n### 숫자만 입력 해주세요 ###\n");
                input = -1; // 첫 반복에서 종료되지 않게 값 변경
            } catch (IOException e) {
                System.out.println("\n### 입출력 관련 예외 발생 ###\n");
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (input != 0);
    }

    private void TodoListFullView() {
        System.out.println("\nTodo List Full View \n");

        List<Todo> todoList = service.getTodoList();
        if (todoList.isEmpty()) {
            System.out.println("\n### 할일 목록이 존재하지 않습니다. ###\n");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Todo todo : todoList) {
            System.out.printf("%s %s %s %s%n", todo.getTitle(), todo.getDetail(), todo.isComplete(), todo.getRegDate().format(formatter));
        }
    }

    private void TodoDetailView() throws IOException {
        System.out.println("Todo Detail View");
        System.out.print("조회할 할일 제목 입력>>> ");
        String searchTitle = br.readLine();
        List<Todo> searchList = service.selectTitle(searchTitle);
        if (searchList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        for (Todo todo : searchList) {
            System.out.println(todo);
        }
    }

    private void addTodo() throws IOException {
        System.out.println("할일 추가하기");
        System.out.print("추가할 스케줄 입력 >>> ");
        String title = br.readLine();
        System.out.print("세부사항 입력 >>> ");
        String detail = br.readLine();
        boolean result = service.addTodoList(title, detail);
        if (result) {
            System.out.println("스케줄이 추가 되었습니다.");
        } else {
            System.out.println("이미 존재하는 세부사항입니다.");
        }
    }

    private void completeTodo() throws IOException {
        System.out.println("완료한 스케줄 확인하기");
        System.out.print("완료할 스케줄 제목 입력하기>>> ");
        String searchTitle = br.readLine();
        List<Todo> searchList = service.selectTitle(searchTitle);
        if (searchList.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }
        for (Todo todo : searchList) {
            todo.setComplete(true);
            System.out.println("스케줄이 완료되었습니다: " + todo);
        }
        if(true) {
        	System.out.println("O");
        }
        	
        }
        }
    

