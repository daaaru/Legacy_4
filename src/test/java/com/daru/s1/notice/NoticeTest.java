package com.daru.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daru.s1.MyJunitTest;

public class NoticeTest extends MyJunitTest{
	
	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void listTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void insertTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t2");
		noticeDTO.setContents("c2");
		noticeDTO.setWriter("w2");
		noticeDTO.setHit(3L);
		
		int result = noticeDAO.add(noticeDTO);
		
		assertEquals(1, result);
	}

	@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	@Test
	public void deleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(22L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
	
}
