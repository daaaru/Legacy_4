package com.daru.s1.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daru.s1.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	//detail
	public NoticeDTO detail(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.detail(noticeDTO);
	}

	//list
	public List<NoticeDTO> list(Pager pager) throws Exception {
		
		//전처리작업
		pager.makeRow();
		Long totalCount = noticeDAO.total();
		pager.makeNum(totalCount);
		
		//호출후 후처리작업
		List<NoticeDTO> ar = noticeDAO.list(pager);
		
		return ar;
	}
	
	//add
	public int add(NoticeDTO noticeDTO) throws Exception {
		return noticeDAO.add(noticeDTO);
	}
	
	
}