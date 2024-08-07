package run;

import java.util.HashSet;
import java.util.Scanner;

public class Exam {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>(); 
		set.add("문미미");
		set.add("박보배");
		set.add("송성실");
		set.add("윤예의");
		set.add("정재주");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 이름을 입력하세요 : ");
		String input = sc.nextLine();// 1
			boolean flage = true;
			for(String name : set){//2
				if(input.equals(name)){//3
					flage = false; //flage 사용방법
					System.out.println(input +"있음");
					return;
				}
			}
			
			if(flage)System.out.println(input+"없음");
			}
}


// 문제 원인 
// 1. 18번째 줄에 sc.nextInt() 문제 발생 
// 1-1. sc.nextInt Int 값이 아닌 String 
// 2. 20번째 줄 for문 문제 발생 
// 2-1 set은 List와 달리 순서 정렬이 되어 있지 않아 적용이 되지 않음
// 3. 23번째 줄 name == input 문제 발생
// 3-1 == 은 문자열에 적용되지 않아 equals 사용해야함
// 4. ?? 4번쨰가 존재하는건가?