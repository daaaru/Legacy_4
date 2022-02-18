package com.daru.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.daru.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest{

	@Autowired
	private BankBookDAO bankBookDAO;
	
	//@Test
	public void check() {
		assertNotNull(bankBookDAO);
	}
	
	//@Test
	public void listTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.list();
		assertNotEquals(0, ar.size());
	}
	//insert
	//@Test
	public void addTest() throws Exception{
		for(int i=0;i<10;i++) {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookname("bookName"+i);
		bankBookDTO.setBookcontents("Contents"+i);
		bankBookDTO.setBookrate(1.12+i);
		bankBookDTO.setBooksale(1);
		int result = bankBookDAO.add(bankBookDTO);
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
