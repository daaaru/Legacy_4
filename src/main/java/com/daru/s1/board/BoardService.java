package com.daru.s1.board;

import java.util.List;

import com.daru.s1.util.Pager;

public interface BoardService {

	//list
	public List<BoardDTO> list (Pager pager)throws Exception;
	
	//datail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	//add
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
}
