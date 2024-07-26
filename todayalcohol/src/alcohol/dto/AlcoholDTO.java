package alcohol.dto;

public class AlcoholDTO {
	private String name;// 이름
	private int proof; // 도수
	private int price;// 가격
	
	public AlcoholDTO() {} // 기본 생성자 

	public AlcoholDTO(String name, int proof, int price) {
		super();
		this.name = name;
		this.proof = proof;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProof() {
		return proof;
	}

	public void setProof(int proof) {
		this.proof = proof;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "name=" + name + ", proof=" + proof + "% , price=" + price + "]";
	}
	
}
