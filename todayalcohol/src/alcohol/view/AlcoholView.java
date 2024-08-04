package alcohol.view;

import java.util.List;
import java.util.Scanner;

import alcohol.dto.AlcoholDTO;
import alcohol.service.AlcoholService;

public class AlcoholView {

	private static final boolean String = false;
	private Scanner sc = new Scanner(System.in);
	private AlcoholService service = new AlcoholService();

	public void mainMenu() {
		int input = 0;

		do {
			System.out.println("\n***** 술 찾아보기 프로그램 *****\n");

			System.out.println("1. 전체 조회");
			System.out.println("2. 주종으로 조회");
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

			switch (input) {
			case 1:
				selectAll();
				break;
			case 2:
				selectList();
				break;
			case 3:
				selectName();
				break;
			case 4:
				selectCountry();
				break;
			case 5:
				selectPrice();
				break;
			case 6:
				addAlcohol();
				break;
			case 7:
				removeAlcohol();
				break;
			case 8:
				updateAlcohol();
				break;
			case 0:
				System.out.println("프로그램 종료");
				break;
			default:
				System.out.println("술에 이미 많이 취하셨네요~ ㅎㅎ");

			}
		} while (input != 0);
	}

	
	private void selectList() {
	    // 술 종류 목록 출력
	    System.out.println("\n술 찾아보기 프로그램\n");
	    System.out.println("1. 소주");
	    System.out.println("2. 맥주");
	    System.out.println("3. 와인");
	    System.out.println("4. 보드카");
	    System.out.println("5. 꼬냑");
	    System.out.println("6. 위스키");
	    System.out.println("7. 럼");
	    System.out.println("8. 막걸리 (+)");
	    System.out.println("0. 종료");
	    System.out.println();
	    
	    System.out.print("검색할 주종 이름 입력: ");
	    String type = sc.nextLine();  
	    
	    // 입력이 비어있거나 숫자가 포함된 경우 처리
	    if (type.isEmpty()) {
	        System.out.println("입력 값이 비어있습니다. 주종 이름을 입력해 주세요.");
	        return;
	    }
	    if (type.matches(".*\\d.*")) {
	        System.out.println("숫자가 포함된 이름은 검색할 수 없습니다. 숫자가 없는 이름으로 검색해 주세요.");
	        return;
	    }
	    
	    List<AlcoholDTO> searchList = service.selectType(type);
	    
	    if (searchList.isEmpty()) {
	        System.out.println("조회 결과가 없습니다.");
	    } else {
	        for (AlcoholDTO alcohol : searchList) {
	            System.out.println(alcohol);
	        }
	    }
	}
	private void selectAll() {
		System.out.println("\n 전체 조회 \n");
		List<AlcoholDTO> AlcoholList = service.selectAll();
		for (int i = 0; i < AlcoholList.size(); i++) {
			System.out.println(i + 1 + ")" + AlcoholList.get(i));
		}
	}


	private void selectName() {
		System.out.println("\n 술 이름으로 조회(포함)\n");

		System.out.println(" 검색할 술 이름 입력:");
		String name = sc.nextLine();
		List<AlcoholDTO> searchList = service.selectName(name);
		if (searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다 ");
			return;
		}
		for (AlcoholDTO alcohol : searchList) {
			System.out.println(alcohol);
		}
	}

	private void selectCountry() {
		System.out.println("\n 국가 이름으로 술 조회(포함)\n");

		System.out.println(" 검색할 국가 이름 입력:");
		String country = sc.nextLine();
		List<AlcoholDTO> searchList = service.selectCountury(country);
		if (searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다 ");
			return;
		}
		for (AlcoholDTO alcohol : searchList) {
			System.out.println(alcohol);
		}

	}

	private void selectPrice() {
		System.out.println("\n가격으로 조회 \n");

		System.out.print("최소값 입력 : ");
		int min = sc.nextInt();

		System.out.print("최대값 입력 : ");
		int max = sc.nextInt();
		List<AlcoholDTO> searchList = service.selectPrice(min, max);

		if (searchList.isEmpty()) {
			System.out.println("조회 결과가 없습니다 ");
			return;
		}

		for (AlcoholDTO Alcohol : searchList) {
			System.out.println(Alcohol);
		}
	}

	private void addAlcohol() {
		System.out.println("술 추가 하기");
		System.out.print("국가 : ");
		String country = sc.nextLine();
		System.out.print("주종 : ");
		String type = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("도수(proof로 입력하세요) : ");
		int proof = sc.nextInt();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		AlcoholDTO newAlcohol = new AlcoholDTO(country, type, name, proof, price);
		boolean result = service.addAlcohol(newAlcohol);
		if (result) {
			System.out.println("추가완료");
		} else {
			System.out.println("추가 중 문제 발생");
		}
	}

	private void removeAlcohol() {
		System.out.println("술 제거하기");
		System.out.println("술의 이름을 입력해 주세요");
		String name = sc.nextLine();
		String result = service.removeAlcohol(name);
		if(result == null){
			System.out.println("해당 이름이 존재하는 술이 없습니다");
			return;
		}
		System.out.printf("%s가 목록에서 제거 되었습니다.",result);
		List<AlcoholDTO>AlcoholList = service.selectAll();
		
			System.out.println();
		}
	

	private void updateAlcohol() {
	    System.out.println("술 가격 수정하기");
	    System.out.print("수정할 술의 이름 입력: ");
	    String name = sc.nextLine();
	    if (name.matches(".*\\d.*")) {
	        System.out.println("숫자가 아닌 이름으로 검색해 주세요");
	        return;
	    }
	    List<AlcoholDTO> searchList = service.selectName(name);
	    if (searchList.isEmpty()) {
	        System.out.println("해당 이름의 술이 목록에 없습니다.");
	        return;
	    }
	    AlcoholDTO alcohol = searchList.get(0);
	    System.out.println("현재 가격: " + alcohol.getPrice());
	    System.out.println("수정할 가격 입력 : ");
		int newPrice = sc.nextInt();
		int beforePrice = alcohol.getPrice();
		alcohol.setPrice(newPrice);
		System.out.printf("[%s] 가격이 (%d)원에서 -> (%d)원으로 수정 되었습니다 \n",
				alcohol.getName(), beforePrice, newPrice);
	}
}
	
