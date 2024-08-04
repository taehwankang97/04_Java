package view;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import service.TodoListService;
import service.TodoListServiceImpl;

public class TodoListView {
	private TodoListService service = null;
	private BufferedReader br = null;
	public TodoListView() {
		try {
			service = new TodoListServiceImpl();
			br = new BufferedReader(new InputStreamReader(System.in));
		}catch(Exception e) {
			System.out.println("프로그램 실행중 오류 발생");
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	public void mainMenu() throws IOException {
		int input = 0;
		do {
			try {
				input = selectMenu();
				switch(input) {
				case 1 : break;
				case 2 : break;
				case 3 : break;
				case 4 : break;
				case 5 : break;
				case 6 : break;
				case 0 : break;
				default : 
				}
			}catch (NumberFormatException e) {
				System.out.println("숫자만 입력 해주세요");
				input = -1;
			}catch(IOException e) {
				System.out.println("입출력 관련 예외 발생");
				e.printStackTrace();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(input != 0);
		
		
	}
	private int selectMenu() throws NumberFormatException, IOException {
		System.out.println("회원 관리 프로그램");
		
		System.out.println("1. TodoList Full View ");
		System.out.println("2. Todo Detail View");
		System.out.println("3. Todo Add ");
		System.out.println("4. Todo Complete");
		System.out.println("5. Todo UpDate");
		System.out.println("6. Todo Delete");
		System.out.println("0. Exit");
		System.out.print("메뉴 선택 >>>");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
}
