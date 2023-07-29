package com.mis.persistence;

import java.util.List;

import com.mis.domain.BoardVO;

public interface BoardDAO {
	
	public void create(BoardVO vo) throws Exception;

	public BoardVO read(int vo) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(int bno) throws Exception;

	public List<BoardVO> listAll() throws Exception;
	
}