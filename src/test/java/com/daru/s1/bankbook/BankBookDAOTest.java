package com.daru.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daru.s1.MyJunitTest;
import com.daru.s1.util.Pager;

public class BankBookDAOTest extends MyJunitTest{

	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBooknumber());
		System.out.println(ar.get(4).getBooknumber());
		assertEquals(5, ar.size());
	}
	//insert
	//@Test
	public void addTest() throws Exception{
		
		
		for(int i=0;i<200;i++) {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookname("bookName"+i);
		bankBookDTO.setBookcontents("Contents"+i);
		
		double rate = Math.random();//0.0~1.0미만의 더블타입리턴
		rate = rate*1000;//123.45567
		int r = (int)rate;//123
		rate = r/100.0;
		
		bankBookDTO.setBookrate(rate);//총3자리, 소숫점2자리
		bankBookDTO.setBooksale(1);
		int result = bankBookDAO.add(bankBookDTO);
		
			if(i%10==0) {
			Thread.sleep(1000);//1초동안 멈춤
			}
		}
		System.out.println("Insert Finish");
		//assertEquals(1, result);
	}
	
	//detail
	//@Test
	public void detailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBooknumber(21L);
		bankBookDTO = bankBookDAO.detail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
//	//detail
//	@Test
//	public void detailTest() throws Exception {
//		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBooknumber(2L);
//		bankBookDTO = bankBookDAO.detail(2L);
//		assertNotNull(bankBookDTO);
//	}
	
	//delete
	//@Test
	public void deleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBooknumber(2L);
		int result = bankBookDAO.delete(bankBookDTO);
		assertEquals(1, result);
	}
	
}
