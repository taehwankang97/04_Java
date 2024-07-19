package field.pkg1;

public class FieldRun {

	public static void main(String[] args) {

		// FiedTest1 객체 생성
		FieldTest1 f1 = new FieldTest1();
		//protected 필드 직접 접근
		System.out.println(f1.protectedValue);
		
		//public 필드 직접 접근
		System.out.println(f1.publicValue);
		
		//defaultValue필드 직접 접근
		// -> 같은 패키지라서 가능!! 
		System.out.println(f1.defaultValue);
		
		
		
		
		//private 필드 직접 접근 -> 문제 발생
		// - 다른 곳/객체가 
		// private(개인적인) 필드 접근 할 수 없다!
		//System.out.println(f1.privateValue);
	}

}
