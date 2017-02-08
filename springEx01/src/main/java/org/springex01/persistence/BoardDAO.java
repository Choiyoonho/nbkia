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
	/* listCriteria�� Criteria ��ü�� �Ķ���ͷ� ���޹ް�
	 * �ʿ��� getPageStart()�� getPerPageNum() �޼ҵ带 ȣ���� ����� ����ϰ� �ȴ�. */
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	/* totalCount�� ��ȯ�� �� �ְ� ó���ϱ� ���ؼ� */
	public int countPaging(Criteria cri) throws Exception;
	/* seach */
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	public void updateReadCount(int bno) throws Exception;
}
