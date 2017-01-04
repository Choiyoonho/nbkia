package org.springex01.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springex01.domain.BoardVO;
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

}
