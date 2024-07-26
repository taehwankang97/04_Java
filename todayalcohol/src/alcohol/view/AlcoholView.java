package alcohol.view;

import java.util.List;
import java.util.Scanner;

import alcohol.dto.AlcoholDTO;
import alcohol.service.AlcoholService;

public class AlcoholView {
	private Scanner sc = new Scanner(System.in);
	private AlcoholService service = new AlcoholService();

	public void mainMenu() {
		int input = 0;

		do {
			System.out.println("\n***** 술 찾아보기 프로그램 *****\n");

			System.out.println("1. 전체 조회");
			System.out.println("2. 목록 보기");
			System.out.println("3. 술 이름으로 조회(포함)");
			System.out.println("4. 국가 이름으로 조회(포함)");
			System.out.println("5. 가격으로 조회");
			System.out.println("6. 술 추가하기");
			System.out.println("7. 단종된 술 입력 해서 제거하기");
			System.out.println("8. 술 가격 수정하기");
			System.out.println("0. 종료");

			System.out.println(); // 줄 바꿈

			System.out.print("메뉴 선택 >> ");
			input = sc.nextInt();
			sc.nextLine(); // 입력 버퍼에 남은 엔터 제거

			System.out.println(); // 줄 바꿈
			
			switch(input) {
			case 1 : selectAll(); break;
			case 2 : selectList(); break;
			case 3 : selectTitle(); break;
			case 4 : selectCountry(); break;
			case 5 : selectPrice(); break;
			case 6 : addAlcohol(); break;
			case 7 : removeAlcohol(); break;
			case 8 : updateAlcohol();  break;
			case 0 : 
				System.out.println("프로그램 종료");
				break;
			default: 
				System.out.println("술에 이미 많이 취하셨네요~ ㅎㅎ");
			
			}
		}while(input != 0);
	}

	private void selectAll() {
		System.out.println("\n 전체 조회 \n");
		List<AlcoholDTO> AlcoholList = service.selectAll();
		
	}

	private void selectList() {
		
	}

	private void selectTitle() {
		
	}

	private void selectCountry() {
		
	}

	private void selectPrice() {
		
	}

	private void addAlcohol() {
		
	}

	private void removeAlcohol() {
		
	}

	private void updateAlcohol() {
		
	}
}
