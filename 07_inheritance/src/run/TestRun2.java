package run;

import dto.Child1;
import dto.parent;

public class TestRun2 {

	public static void main(String[] args) {
		
		//부모객체 생성
		parent p1 = new parent();
		
		p1.introduce();
		
		System.out.println("------------------------------------------------------------------------------");
		
		// 자식 객체 생성
		Child1 c1 = new Child1(); // soqndp parent 객체 존재
		c1.introduce();
		
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("[Object.toString() 오버라이딩 확인]");
		
		System.out.println(p1.toString());
		System.out.println(p1); // 참조 변수명만 작성해도
								// -> toString() 자동호출
		
		System.out.println("------------------------------------------------------------------------------");
		
		System.out.println("[Parnet.toString() 오버라이딩 확인]");
		
		c1.setNotebook("LG Gram");
		System.out.println(c1);
		
	}
	
	/* final메서드 
	 * 
	 * - 오버라이딩 불가 
	 * -> 부모의 메서드가 완벽해서 또는 재정의하면 문제가 되서
	 * 	  더이상 오버라이딩을 못하게 하겠다
	 *    (마지막으로 정의된 메서드)
	 * 
	 * -public final 반환형 메서드명(){}
	 * 
	 */
	
	public final void onlyParent(){
		System.out.println("final 메서드 입니다");
	}
}
