package com.daru.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daru.s1.MyJunitTest;
import com.daru.s1.util.Pager;

public class NoticeTest extends MyJunitTest{
	
	@Autowired
	private NoticeDAO noticeDAO;

	//@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPage(1L);
		//makeRow메서드 호출해야함
		pager.makeRow();
		List<NoticeDTO> ar = noticeDAO.list(pager);
		assertNotEquals(0, ar.size());
	}
	
	//@Test
	public void insertTest() throws Exception {
		
		
		for(int i=0;i<200;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("Title"+i);
			noticeDTO.setContents("Contents"+i);
			noticeDTO.setWriter("Writer"+i);
			
			Long hit = (long)(Math.random()*100)+1;
			
			noticeDTO.setHit(hit);
			int result = noticeDAO.add(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("Insert Finish");
		
		//assertEquals(1, result);
	}

	//@Test
	public void detailTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(21L);
		noticeDTO = noticeDAO.detail(noticeDTO);
		assertNotNull(noticeDTO);
	}
	
	//@Test
	public void deleteTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(22L);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);
	}
	
}
