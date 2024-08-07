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
                        // updateTodo();
                        break;
                    case 6:
                    	deleteTodo();
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
    
	private void updateTodo() throws IOException {
		System.out.println("\n=== Todo Update ===\n");
		
		System.out.print("수정할 할 일 인덱스 번호 입력 >>>>>");
		int input = Integer.parseInt(br.readLine());
		
		List<Todo> searchList = service.selectIndex(input);
		
		if(searchList.isEmpty()) {
			System.out.println("\n### 일치하는 할 일이 없습니다. ###\n");
			return;
		}
		
		
		for(Todo todo : searchList) {
			
			System.out.println("수정 전");
			System.out.println("--------------------------------------------");
		
		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
			System.out.println("------------------------------------");
			System.out.println("제목 : " + todo.getTitle());
			System.out.println("등록일 : " + todo.getRegDate().format(formatter));
			System.out.println("완료 여부 : " + (todo.isComplete() ? "O" : "X"));
			System.out.println("------------------------------------");
			System.out.println("[세부 내용]\n" + todo.getDetail());
		}
		
		// 수정할 상세 내용 입력
		System.out.println("제목 : ");
		String title = br.readLine();
		
		StringBuilder detailBuilder = new StringBuilder();
        String line;

        // 세부내용 입력 안내 메시지를 한 번만 출력
        System.out.println("세부내용 작성(입력 종료 시 !wq 작성 후 엔터)");
        System.out.println("----------------------------------------------");
        
        while (true) {
            line = br.readLine();
            if ("!wq".equals(line.trim())) { // 사용자가 입력한 문자열이 !wq인지 확인
                System.out.println("----------------------------------------------");
                break;
            }
            detailBuilder.append(line).append("\n"); // 세부내용을 StringBuilder에 추가
        }
        
        String detail = detailBuilder.toString().trim(); // 세부내용의 앞뒤 공백 및 개행 제거
        
        // 제목, 상세내용으로 할일 목록 추가 후 결과 반환받기
        boolean result = service.addTodoList(title, detail);
		
		if(result) {
			List<Todo> todoList = service.getTodoList();
			
			for(int i = 0; i < todoList.size(); i++) {
				if(todoList.get(i).getTitle().equals(title)) {
					System.out.printf("\n*** [수정 되었습니다.] ***\n", i);
					break;
				}
			}
		}
	}
    private void deleteTodo() throws IOException {
		System.out.print("\n Todo Delete \n");
		  
		// 삭제할 할 일 제목 입력받기
		System.out.print("삭제할 할 일 인덱스 번호 입력 >>> ");
		int input = Integer.parseInt(br.readLine());
				
		// 제목이 일치하는 회원 모두 조회
		List<Todo> searchList = service.selectIndex(input);
				
		// 제목이 일치하는 회원이 없을 경우
		if(searchList.isEmpty()) {
			System.out.println("\n### 제목이 일치하는 할 일이 없습니다. ###\n");
			return;
			}
				
		
		// 정말 삭제를 할 것인지 확인 
		System.out.print("정말 삭제 처리 하시겠습니까? (Y/N)");
				
		// 입력받은 문자열을 소문자로 만들어
		// 제일 앞 문자 하나만 반환 받기
		char check = br.readLine().toLowerCase().charAt(0);
			
		if(check == 'n') { // n 입력한 경우
			System.out.print("\n삭제 취소\n");
			return;
		}
				
		if(check != 'y') { // 잘못 입력한 경우
			System.out.println("\\n잘못 입력 하였습니다. 다시 시도해주세요.\\n");
			return;
		}

		
		String result = service.removeMember(input);
				
		System.out.println(result);  
	}
	
	
}

        
    

