package loop.ex;

import java.util.Scanner;

public class LoopEx1 {

	// 필드
	Scanner sc = new Scanner(System.in);

	/**
	 * 1부터 10까지 추력하기
	 */
	public void method1() {
		// Java는 초기식 변수 선언 시 let X -> Java 자료형
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	}

	/**
	 * 첫 번째 입력 받은 수 부터 두 번쨰 입력 받은 수 이하 까지 세 번쨰 입력 받은 수 만큼 증가하면 출력하기
	 */
	public void method2() {
		System.out.println("시작 끝 증가값 : ");
		int start = sc.nextInt();
		int end = sc.nextInt();
		int value = sc.nextInt();

		for (int i = start; i <= end; i += value) {
			System.out.println(i);
		}
	}

	/**
	 * 두 수를 입력 받아 작은 수 부터 큰 수 이하 까지 1 씩 증가하면 반복
	 */
	public void method3() {
		System.err.print("숫자 2개 입력");

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("===========================================");
		if (a < b) {
			for (int i = a; i <= b; i++) {
				System.out.println(i);
			}
		} else {
			for (int i = b; i <= a; i++) {
				System.out.println(i);
			}

		}

		System.out.println("==========================================================");
		// 추가 변수를 이용해서 시작, 종료 값 지정하기
		int start = a;
		int end = b;

		if (a > b) {// 시작이 끝 보다 큰 경우
			start = b;
			end = a;
		}
		for (int i = start; i <= end; i++) {
			System.out.println(i);
		}
		System.out.println("==========================================");
		// a에는 작은 값, b에는 큰 값 저장하게 만들기
		if (a > b) {
			int temp = a;// a값을 보관하는 임시 변수
			a = b;
			b = temp;
		}
		for (int i = a; i <= b; i++) {
			System.out.println(i);
		}

		System.out.println("======================================================");

		// 자바에서 제공하는 기능(메서드)이용

		int min = Math.min(a, b);// a,b중 작은 값
		int max = Math.max(a, b);

		for (int i = min; i <= max; i++) {
			System.out.println(i);
		}

	}

	/**
	 * 1부터 100사이의 정수중 5의 배수의 합과 계수를 구하기 sum, count
	 */
	public void method4() {
		int sum = 0;
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 5 == 0) {// 5의 배수인 경우
				sum += i;// i값 누적
				count++; // count 1 증가
			}
		}
		System.out.printf("합계 : %d / 개수 : %d", sum, count);

	}

	// 구구단 3단 출력하기
	public void method5() {
		for (int i = 1; i <= 9; i++) {
			System.out.printf(" 3 X %d = %d \n", i, (3 * i));
		}
	}

	/**
	 * 입력 받은 단 출력 하기 단, 입력 받은 단이 2 ~ 9 숫자가 아니면 "잘못 입력 하셨습니다"
	 */

	public void method6() {
		System.out.println("단 입력 (2~9)");
		int dan = sc.nextInt();

		if (dan < 2 || dan > 10) {
			System.out.println("잘못 입력하셨습니다");
			return;
		}
		for (int i = 1; i <= 9; i++) {
			System.err.printf("%d x %d = %d", dan, i, (dan * i));

		}

	}

	public void method7() {
		int num = 1;
		// 조건식이 true인 경우에 반복수행
		while (num <= 10) {
			System.out.print(num + " ");
			num++;
		}

	}

	// for -> (초기식;조건식;증감식)
	// -> 지정된 횟수 만큼 반복
	// while(조건식)
	// -> 조건식이 false가 될 때 까지
	// == 몇회인지 모르겠지만 끝날때 까지 반복

	/** [구구단 출력하기 version.2]
	 * 입력 받은 단 출력하기
	 * 단, 입력 받은 단이 2 ~ 9 사이 숫자가 아니면
	 * "잘못 입력 하셨습니다" 출력후 
	 * 다시 단 입력 받기
	 */
	public void method8() {
		int dan;
		while(true){// 무한 반복
			System.out.println("단 입력 (2~9)");
			dan = sc.nextInt();

			if(dan >= 2 && dan <=9) {
				break;
			}
			System.out.println("잘못 입력하셨습니다");
		}
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%d x %d = %d\n", dan, i, (dan *i));
			 
				
			
		}
	}

}
