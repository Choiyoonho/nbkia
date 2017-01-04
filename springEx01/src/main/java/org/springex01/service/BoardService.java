package org.springex01.service;

import java.util.List;

import org.springex01.domain.BoardVO;

public interface BoardService {
	public void register(BoardVO board) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void modify(BoardVO board) throws Exception;
	public void remove(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
}
