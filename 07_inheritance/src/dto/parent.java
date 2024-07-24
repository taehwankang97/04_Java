package dto;

/**Object 클래스
 *  - 모든 클래스(객체)의 최상위 부모
 *  - 모든 클래스 (객체)가 공통적으로 가져야 하는 기능이 모여있음  
 *  
 *  - 클래스 선언부에 아무런 상속 구문 (extends)
 *    작성되어 있지 않으면
 *    컴파일러가 extends Object 구문울 추가해 준다.
 */


/**
 * 부모 역활 클래스
 */
public class parent extends Object {
	
	//부모 필드
	// protected 접근 제한자 : 
	// 같은 패키지 : 객체 생성후 사용
	// ex) 자식 클래스에서 
	//		parent p = new parent(); p.lastName
	
	//상속 관계 자식 클래스 :  자식 클래스에서 직접 사용
	// ex) 자식 클래스에서 lastName 작성
	protected  String lastName = "홍"; // 명시적 초기화
	
	private String address = "서울시 중구 남대문로 120";
	
	private int money = 100_000_000; // _ : 자릿수 구분 (해석)
	
	private String car = "그랜져";
	
	// 매개 변수 생성자
	public parent( String address, int money, String car) {
		this.address = address;
		this.money = money;
		this.car = car;
		
		System.out.println("부모 - 매개변수생선자로 객체 생성");
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	/**
	 * 현재 객체의 필드 값을 하나의 문자열로 반환하는 메서드
	 * @return
	 */
	public String inform() {
		return String.format("%s/%s/%s/%s", lastName, address, money, car);
		
	}
	public parent() {
		System.out.println("부모 - 기본 생성자로 객체 생성");
	}

	/**
	 * 자기소개 기능
	 */
	public void introduce() {
		System.out.println("저는 parent입니다.");
	}
	
	/* object 클래스에서 상속 받은 메서드중 
	 * toString() 메서드 오버라이딩 하기
 	 * 
 	 * - Object.toString()역활
 	 *  ->물려받은 자식이 오버라이딩 하여 
 	 *    객체가 가지고 있는 필드 값을 
 	 *    하나의 문자열로 만드는 것임 (약속 되어 있음!!)
 	 *    
 	 *    -> print()관련 국문에서 
 	 *    ()안에 참조 변수명만 작성해도
 	 *    자동으로 toString()이 호출된다.
	 */
	@Override// 오버라이딩 잘 되었는지 검사
	public String toString() {
		return String.format("[parent]%s/%s/%s/%s", lastName, address, money, car);
		
	}
}
