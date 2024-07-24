package pkg1.run;

import pkg1.dto.Child;
import pkg1.dto.Parent;

public class TestRun {
	public static void main(String[] args) {
	
	// 부모 참조 변수 = 부모 객체 
	// -> 양쪽 다 Parent 타입 
	// == 컴퓨터 값 처리 원칙 잘 지켜짐
	Parent p1 = new Parent();
	
	// 사용 가능한 필드/ 메서드 : Object, Parent
	System.out.println(p1.getLastName());
	System.out.println(p1.hashCode());
	
	// 자식 참조 변수 = 자식 객체
	Child c1 = new Child();
	
	//사용가능한 필드/ 메서드 :  Object, Parent, Child
	
	System.out.println(c1.hashCode());
	System.out.println(c1.getLastName());
	System.out.println(c1.getCar());
	System.out.println("==================================================");
	
	/* 다형성에서 - 업캐스팅 (Up Casting)
	 * 
	 * - "부모" 참조 변수 = '자식' 객체
	 * 	
	 * - 상속 관계에서만 가능
	 * 
	 * 	참조하는 자식 객체가 부모 객체로 변함
	 */
	
	Parent p2 = new Child(); // 오류 안남
	
	// 사용 가능한 필드/메서드 
	
	System.out.println(p2.hashCode());
	System.out.println(p2.getLastName());
//System.out.println(p2.getCar); -> Child 메서드 접근 불가
	
	System.out.println("-----------------------------");
	
	/* *** 다운 캐스팅 (Down Casting)***
	 * 
	 * 업 캐스팅 상태에서(부모참조 = 자식객체)
	 * 참조변수의 자료형을 
	 * 자식객체 자료형으로 강제 형변환 하는것 
	 * 
	 */
	
	Parent p3 = new Child(); // 업캐스팅 상태
	
	//p3(Parent)를 Child로 강제 형 변환 하여 
	//반환된 주소 c3에 저장
	Child c3  = (Child)p3;
	
	//아래 방법 처럼 필요할 때 마다 형변환 가능 하지만 
	// 가독성이 떨어져 보통 자식 참조 변수에 대입해 사용 
	//((Child)p3).getCar();
	
	System.out.println(c3.getCar());// 자식 메서드 참조 가능
	
	System.out.println("--------------------------------------------------");
	
	/* Object를 이용한 업캐스팅
	 * -> 객체 타입에 따른 다운 캐스팅
	 * 
	 */
	
	// Object : 모든 클래스 (객체)의 최상위 부모
	Object[] arr = new Object[3];
				  // Object 참조 변수 3개 묶음 
	
	// Object 참조 변수 = Parent/Child/Object 객체 
	arr[0] = new Parent(); // Parent -> Object 업 캐스팅
	arr[1] = new Child(); // Child -> Object로 업 캐스팅
	arr[2] = new Object(); // 같은 자료형 연산
	
	/*instanceof 연산자
	 * [작성법 ]
	 * 참조변수명 instanceof 클래스명
	 * 
	 * - 참조하고 있는 객체가
	 * 클래스명 객체가 맞는지 확인 결과 : (ture/false)
	 * 
	 * *** 주의 사항 *** 
	 * -instanceof는 참조하고 있는 객체가 
	 * 	상속하고 있는객체도 같이 확인하기 때문에 
	 * 	자식 객체를 참조하는 변수에
	 * 	부모 타비을 검사하면 true가 나온다
	 * 
	 * parent p = new Child(); // 업캐스팅
	 * 
	 * p instanceof Child
	 *  -> p가 참조하는 객체가 Child? true
	 *  
	 *  p instanceof Parent
	 *  -> p가 참조하는 객체가 Parent야? true
	 *  
	 *  ==> 주의 사항을 잘 이용하면 
	 *  	Parent, Child 클래스 상속 관계가 맞는지
	 *  	확인하는 용도로 사용가능
	 * 
	 */
	
	
	// 향상된 for문 
	for(Object obj:arr) {
		/*tip. 자료형을 연달아 검사하는 경우 
		 * 
		 * 마지막 자식 자료형부터 검사하는 것이 좋다*/
		
		//얻어온 요소가 Child 타입이면
		if(obj instanceof Child) {
			System.out.println("Child 입니다");
		}
		//얻어온 요소가 Parent 타입이면
		else if(obj instanceof Parent) {
			System.out.println("parent 입니다");
		}
		// 얻어온 요소가 Object 타입이면
		else {
			System.out.println("Object입니다");
		}
	}
	
	
	
	System.out.println("------------------------------");
	System.out.println("[부모 -> 자식 역순 검사 문제점]");
	
	for(Object obj : arr) {
		// 얻어온 요소가 Object  타입이면
		if(obj instanceof Object) {
			System.out.println("Object 입니다");
		}
		
		// 얻어온 요소가 Parent 타입이면
		else if(obj instanceof Parent) {
			System.out.println("Parent 입니다");
		}
		
		// 얻어온 요소가 Child 타입이면
		else {
			System.out.println("Child 입니다");
		}
	}
	}

}
