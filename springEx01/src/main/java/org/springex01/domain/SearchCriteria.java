package org.springex01.domain;

public class SearchCriteria extends Criteria {
	private String searchType;
	private String keyword;
	
	public SearchCriteria() {
		super();
	}
	public SearchCriteria(int page, int perPageNum) {
		super(page, perPageNum);
	}
	
	public SearchCriteria(String searchType, String keyword) {
		super();
		this.searchType = searchType;
		this.keyword = keyword;
	}
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchCriteria [searchType=");
		builder.append(searchType);
		builder.append(", keyword=");
		builder.append(keyword);
		builder.append("]");
		return builder.toString();
	}
}
