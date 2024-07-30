package pkg4.run;

import pkg4.exception.UserException;

public class UserDefinedExceptionRun {

	public static void main(String[] args) {
		
		try {
			// 사용자 정의 예외 강제 발생
			throw new UserException("와 머리에 안들어간다 그만 제발 그만");
			
			
		}catch(UserException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
