package memberview;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import memberservice.MemberService;
import memberservice.MemberServiceImpl;

public class MemberView {
	private MemberService service = null;
	private BufferedReader br = null;
	public MemberView() {
		try {
			service = new MemberServiceImpl();
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
		
		System.out.println("1. 회원 가입 ");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 이름으로 검색 ");
		System.out.println("4. 특정 회원 사용 금액 누적하기");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6.회원 탈퇴");
		System.out.println("0. 종료");
		System.out.print("메뉴 선택 >>>");
		
		int input = Integer.parseInt(br.readLine());
		System.out.println();
		
		return input;
	}
	
}
