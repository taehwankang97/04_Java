package field.pkg2;

import field.pkg1.FieldTest1;

// 다른 패키지
public class FieldRun2 extends FieldTest1 {
						/* 상속 구문 */
	
	public static void main(String[] args) {
		
		// FieldTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		
		//protected 필드 직접접근
		//문제 발생 상속 관계 아님
		//System.out.println(f1.protectedValue);
		
		
		//publicValue
		System.out.println(f1.publicValue);
		
		// 문제 발생
		//System.out.println(f1.defaultValue);
		
		//private -> 문제 발생
		//System.err.println(f1.privateValue);
		
		
		

	}
	public void method() {
		System.out.println(protectedValue);
	}
}
