package org.springex01.persistence;

import java.util.List;

import org.springex01.domain.BoardVO;
import org.springex01.domain.Criteria;
import org.springex01.domain.SearchCriteria;

public interface BoardDAO {
	public void create(BoardVO vo) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void update(BoardVO vo) throws Exception;
	public void delete(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listPage(int page) throws Exception;
	/* listCriteria는 Criteria 객체를 파라미터로 전달받고
	 * 필요한 getPageStart()와 getPerPageNum() 메소드를 호출한 결과를 사용하게 된다. */
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	/* totalCount를 반환할 수 있게 처리하기 위해서 */
	public int countPaging(Criteria cri) throws Exception;
	/* seach */
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	public void updateReadCount(int bno) throws Exception;
}
