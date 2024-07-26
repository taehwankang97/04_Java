package list.dto;

public class BookDTO {
	private String title;// 제목
	private String writer;// 저자(글쓴이)
	private int prince; // 가격
	
	public BookDTO() {}// 기본 생성자 

	// 매개 변수 생성자
	public BookDTO(String title, String writer, int prince) {
		super();
		this.title = title;
		this.writer = writer;
		this.prince = prince;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public int getPrice() {
		return prince;
	}

	public void setPrice(int prince) {
		this.prince = prince;
	}

	// 이클립스 toString() 자동완성 : alt + shift + s -> s
	@Override
	public String toString() {
		return "책 제목 :" + title + ", 저자 : " + writer + ", 가격 : " + prince + "원]";
	}


	
}
