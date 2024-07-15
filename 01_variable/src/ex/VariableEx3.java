package ex;

public class VariableEx3 {

	public static void main(String[] args) {
		/*---- 강제 형변환 ----
		 * 
		 * 1. 값의 범위가 큰 자료형 -> 작은 자료형으로 변환
		 * 	  (데이터 손실을 고려해야함)
		 * 2.의도적으로 자료형을 변환할 때
		 * 
		 *  [작성법]
		 *  
		 *  (자료형) 변수명;
		 *  	또는 
		 *  (자료형) 값
		 * 
		 * 
		 * -변수명 / 값이 지정된 자료형을 변환
		 * */
		
		System.out.println("강제 형변환 데이터 손실 확인 1");
		
		int num1 = 290;
		byte result = (byte)num1;
		System.out.println("num1 :" + num1);
		System.out.println("result:" + result);
		
		System.out.println("====================================");
		

		System.out.println("강제 형변환 데이터 손실 확인 2");
		
		//실수를 정수로 강제 형변환
		// -> 소수점을 버림으로 실수를 정수로 변환
		//-> 정수 부분만 확인(손실을 활용)
		double num2 = 123.456789;
		int result2 = (int)num2;//int 강제 형변환
		System.out.println("num2: " + num2);
		System.out.println("result2: " + result2);

		System.out.println(num2 - result2);
		//0.45678900000000056 (2진수 소수표현 시 문제점)
		
		/* 난수 + 강제 형변환
		 * JS난수 : Math.radom()
		 * 자료형 : double
		 * */
		//1 ~ 10 사이 난수 (정수)
		//강제 형변환을 이용해 소수점 제거
		int randomNumber = (int)(Math.random() * 10 +1);
		System.out.println("randomNumber : " + randomNumber);
		
		System.out.println("---------------------------");
		
		System.out.println(123);
		System.out.println((double)123);
		
		System.out.println("=================================");
		
		System.out.println("[문자(char)<->유니코드(int)]");
		
		System.out.println("A의 번호" + (int)'A');//65
		System.out.println("A의 번호" + (int)'a');//97
		
		System.out.println("강의 번호" + (int)'강');//44053
		System.out.println("태의 번호" + (int)'태');//53468
		System.out.println("환의 번호" + (int)'환');//54872
		System.out.println("ㄱ의 번호" + (int)'ㄱ');//12593
		System.out.println("ㄱ다음은?" + (char)('ㄱ'+1));// ㄲ
		System.out.println("ㄱ다음은?" + (char)('ㄱ'+2));// ㄳ
		System.out.println("ㄱ다음은?" + (char)('ㄱ'+3));// ㄴ
		
		
		System.out.println("---------------------------------");
		
		System.out.println("[오버플로우]");
		
		// 오버 플로우 (OverFlow)
		// - 연산 결과가 자료형의 값의 범위를 초과(+)한 경우 
		
		// int 자료형 최대 범위 초과
		int max = Integer.MAX_VALUE;
		System.out.println("max : " + max);
		System.out.println("max + 1 :" + (max + 1));
		
		//==============================================================
		
		/*상수
		 * 
		 * -한번 값을 대입하면 바꿀 수 없는 변수
		 * 
		 * [작성법]
		 * final자료형 변수명 = 값
		 * 변수명은 대문자 + _ 형식으로 작성
		 * */
		
		//final double PI = 3.141592;
		
		//final int NATIONAL_CODE = 82;
		
		//NAIONAL_CODE = 11;->값 대입 불가
	
	
	
	
	
	
	
	
	
	
	}

}
