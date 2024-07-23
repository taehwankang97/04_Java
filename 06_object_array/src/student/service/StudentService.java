package student.service;

import java.util.Random;

import student.dto.StudentDTO;

// 기능(비즈니스 로직) 제공용 클래스 
public class StudentService {

	// studentDTO 객체를 참조하는
	// studentDTO 참조변수 5개 묶음 배열 생성
	// 인덱스 0 ~ 4
	// 각 인덱스 요소 : 초기값 null
	private StudentDTO[] students = new StudentDTO[5];

	/* 기본 생성자 */
	public StudentService() {

		// 학생 객체 배열(students)에 샘플 학생 3명 추가

		// student[0] : StudentDTO 자료형 참조 변수
		students[0] = new StudentDTO("24001", "짱구", '남');
		students[1] = new StudentDTO("24002", "유리", '여');
		students[2] = new StudentDTO("24003", "맹구", '남');

		// studnet[3]/[4] == null

		// 0 ~ 100 난수 발생
		// 1) Math.floor(Math.random()*101) == 0 ~ 100
		// 2) Random random - new Random
		// random.next(101); == 0 ~ 100

		Random random = new Random();

		for (StudentDTO std : students) { // 향상된 for문
			// 현재 접근한 요소가 참조하는 객체가 없다면
			// 반복 종료
			if (std == null)
				break;

			// random.nextInt(101) : 0이상 101미만
			std.setHtml(random.nextInt(101));
			std.setCss(random.nextInt(101));
			std.setJs(random.nextInt(101));
			std.setJava(random.nextInt(101));
		}
	}

	/**
	 * 학생 객체 배열 studnent 중 비어있는 인덱스에 전달 받은 학생 객체(std) 추가
	 * 
	 * @param std : 입력 받은 값을 저장한 학생 객체 주소
	 * @return : true : 추가 성공 / false : 추가 실패 - 실패 조건 : student 배열이 꽉 차있는데 추가 학행이
	 *         전달된 경우
	 */
	public boolean addStudent(StudentDTO std) {

		// 0번 인덱스 부터
		// 순서대로 비엉있는 (null) 요소를 찾아
		// 전달 받은 std를 대입

		for (int i = 0; i < students.length; i++) {

			if (students[i] == null) {// i번째 요소가 비어있는 경우
				students[i] = std;
				return true;
			}
		}

		// 비어있는 (null)인 요소가 없을 경우 false 반환
		return false;
	}

	/**
	 * students 객체 배열에 저장된 주소를 얻어가게 하는 메서드
	 * 
	 * @return students 객체 배열에 저장된 주소
	 */
	public StudentDTO[] getStudents() {
		return students;
	}

	/**
	 * 학생 1명 정보 조회 (index 검색)
	 * 
	 * @param index
	 * @return 조회된 학생 객체 주소
	 */
	public StudentDTO selectIndex(int index) {

		// 전달 받은 index 범위가 students의 인덱스 범위밖인 경우
		if (index < 0 || index >= students.length) {
			return null;
		}

		return students[index];
	}

	/**
	 * 전달 받은 이름과 이름이 일치하는 학생 객체를 반환
	 * 
	 * @param targetName
	 * @return null 또는 일치하는 학생 객체(주소 값)
	 */
	public StudentDTO selectName(String targetName) {

		// 향상된 for문
		for (StudentDTO std : students) {
			// 저장된 학생이 없을 경우
			// -> 뒤에도 없을 것! -> 그냥 여기서 검색 종료
			if (std == null)
				return null;
			// == : 기본 자본형 비교
			// A.equals(B) : 참조형 (객체) 비교
			if (std.getName().equals(targetName)) {
				return std;
			}
		}

		return null;
	}

	/**
	 * 전달 받은 index가 students 범위 내인지 + 정상 범위라면 해당 index가 학생 객체를 참조하는지 확인
	 * 
	 * @param index
	 * @return
	 */

	public int checkIndex(int index) {
		// 입력 받은 index가 정상인지 판별
		// 1 == 범위 초과
		// 2 == 학생 없음
		// 3 == 정상

		if (index < 0 || index >= students.length)
			return 1;

		if (students[index] == null)
			return 2;
		return 3;

	}

	/**
	 * 전달 받은 index 번째 학생의 점수 수정
	 * 
	 * @param index
	 * @param scores
	 */
	public void updateScores(int index, StudentDTO other) {

		// 객체 배열 : 객체 참조형 변수를 묶음으로 다룸

		// students[index] 번째에 저장된 주소 얕은 복사
		StudentDTO s = students[index];
		s.setHtml(other.getHtml());
		s.setCss(other.getCss());
		s.setJs(other.getJs());
		s.setJava(other.getJava());
	}

	/**
	 * 평균 최대/최소 구하기
	 * @return
	 * 최고점 : 짱구 (85.4)
	 * 최저점 : 맹구 (61.5)
	 */
	
	

	public String selectMaxMin() {
	    String BN = "";
	    String WN = "";
	    double BA = Double.MIN_VALUE;
	    double WA = Double.MAX_VALUE;
	    
	    for (StudentDTO std : students) {
	        if (std == null) {
	            continue;
	        }
	        
	        int sum = std.getHtml() + std.getCss() + std.getJs() + std.getJava();
	        double avg = sum / 4.0;
	        
	        if (avg > BA) {
	            BA = avg;
	            BN = std.getName();
	        }
	        
	        if (avg < WA) {
	            WA = avg;
	            WN = std.getName();
	        }
	    }
	    
	    String result = String.format("최고점 : %s(%.1f)\n최저점 : %s(%.1f)\n",BN , BA, WN, WA);
	    return result;
	}

	
}


