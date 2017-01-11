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
	/* XML Mapper���� ����ϴ� getter ���� */
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
	 * XML Mapper���� ����ϴ� getter ���� 
	 * limit �������� ���� ��ġ�� ������ �� ���
	 * ex) 10���� ����ϴ� ��� 3�������� �����ʹ� limit 20, 10�� ���� ����
	 * ���� - ���� ������ ��ȣ = (������ ��ȣ -1) * ������ �� �������� ���� 
	 * gerPerPageNum�� limit�� �ڿ� ���ڸ� �ǹ� : �� �������� �������� ����*/
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
