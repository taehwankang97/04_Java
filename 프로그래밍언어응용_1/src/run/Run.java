package run;

import java.util.HashSet;
import java.util.Set;

// 문제점 1. 이론지식이 너무 약하다
// 문제점 2. 오류가 나면 원인을 찾아야 하는데 못찾는다
// 문제점 3. 답안 작성하는 방법 
// 내일 시험 범위 변수 ~ 컬렉션 까지 


public class Run {

	public static void main(String[] args) {
	
	// 컬렉션 : 자바 자료구조 모음 
	
	// List : 배열과 비슷함 
	//        index가 존재해서 순서 유지 
	//        중복 가능 
		
	// Set : (주머니 , 집합 ) 순서가 없어  중복 X 
		
	// Map : K:V 한쌍으로 데이터 저장
	//       중복된 K 불가 
    //       V 구분 가능 -> 중복 O
		
	// Set 객체 생성
	Set<String> menuSet = new HashSet<String>();
	
	// set에 추가
	menuSet.add("라면");
	menuSet.add("김밥");
	menuSet.add("우동");
	menuSet.add("우동"); // 중복 제거 
	menuSet.add("우동");// 중복 제거 

	System.out.println(menuSet);

	// menuSet에 라면이 있는지 검사 
	
	//문제 원인 
	// 일만 for무을 이용해서 다루고 있는 i 값을 통해
	// Set의 i 번째 인덱스를 가져오려고 함
	// 하지만 Set은 인덱스가 없어서 오류가 발생
	
	// 해결 방법 
	// 향상된 for 문 Sey 
//	for(int i = 0 ; menuSet < menuSet.size() ; i++) {
//		if(menuSet.get(i) == "라면 ") {
//			System.out.println("라면 있음 ");
//			
//	}}

	// 메뉴가 존재 할 때도 
	// 있음 / 없음 둘다 출력 하는 문제 발생
	
	//if문에 문자열 비교시 비교연산자 (==)를 이용해서 
	// 값이 아닌 주소를 비교하고 있음
	// 왜?  같은 메뉴를 찾았을 경우
	// 없음을 출력하지 못하게하는 처리가 되지 않았다.
	//1) return을 추가해서 프로그램 종료
	//2) flag를 이용해 없음 구문 실행 여부 처리
	boolean flage = true;
	for(String menu : menuSet){
		if(menu.equals("라면")) {
			flage = false;
			System.out.println("라면 있음");
			return;
		}
	}
	// for 문이 끝났을 떄 
	// 라면이 있으면 flag == false
	// 라면이 없었을 떄 flag == true
	if(flage)System.out.println("라면 없음");
	}
}
