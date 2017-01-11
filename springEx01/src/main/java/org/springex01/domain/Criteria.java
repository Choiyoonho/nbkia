package org.springex01.domain;

public class Criteria {
	private int page;
	private int perPageNum;
	
	public Criteria() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public Criteria(int page, int perPageNum) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page <= 0){
			this.page = 1;
			return;
		}
		this.page = page;
	}
	/* XML Mapper에서 사용하는 getter 제공 */
	public int getPerPageNum() {
		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 10;
			return;
		}
		this.perPageNum = perPageNum;
	}
	
	/* method for MyBatis SQL Mapper 
	 * XML Mapper에서 사용하는 getter 제공 
	 * limit 구문에서 시작 위치를 지정할 때 사용
	 * ex) 10개씩 출력하는 경우 3페이지의 데이터는 limit 20, 10과 같은 형태
	 * 공식 - 시작 데이터 번호 = (페이지 번호 -1) * 페이지 당 보여지는 개수 
	 * gerPerPageNum은 limit의 뒤에 숫자를 의미 : 한 페이지당 보여지는 개수*/
	public int getPageStart() {
		return (this.page - 1) * perPageNum;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Criteria [page=");
		builder.append(page);
		builder.append(", perPageNum=");
		builder.append(perPageNum);
		builder.append("]");
		return builder.toString();
	}
}
