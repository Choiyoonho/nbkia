package org.springex01.service;

import java.util.List;

import org.springex01.domain.BoardVO;
import org.springex01.domain.Criteria;
import org.springex01.domain.SearchCriteria;

public interface BoardService {
	public void register(BoardVO board) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void modify(BoardVO board) throws Exception;
	public void remove(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	public int listCountCriteria(Criteria cri) throws Exception;
	/* search */
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception;
	public int listSearchCount(SearchCriteria cri) throws Exception;
	public void updateReadCount(int bno) throws Exception;
}
