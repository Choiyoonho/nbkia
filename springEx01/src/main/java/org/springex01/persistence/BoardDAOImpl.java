package org.springex01.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springex01.domain.BoardVO;
import org.springex01.domain.Criteria;
import org.springex01.domain.SearchCriteria;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {
	@Inject
	private SqlSession session;
	
	private static String ns = "org.springex01.mapper.BoardMapper";
	@Override
	public void create(BoardVO vo) throws Exception {
		session.insert(ns+".create", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		return session.selectOne(ns+".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(ns+".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(ns+".delete", bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return session.selectList(ns+".listAll");
	}
	
	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		if(page <= 0){
			page = 1;
		}
		page = (page - 1) * 10;
		
		return session.selectList(ns+".listPage", page);
	}
	
	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		return session.selectList(ns+".listCriteria", cri);
	}
	
	@Override
	public int countPaging(Criteria cri) throws Exception {
		return session.selectOne(ns+".countPaging", cri);
	}

	@Override
	public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {
		return session.selectList(ns+".listSearch", cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {
		return session.selectOne(ns+".listSearchCount", cri);
	}
}
