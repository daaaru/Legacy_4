package com.daru.s1.bankbook;

public class BankBookDTO {

	private Long booknumber;
	private String bookname;
	private String bookcontents;
	private Double bookrate;
	private Integer booksale;
	
	public Long getBooknumber() {
		return booknumber;
	}
	public void setBooknumber(Long booknumber) {
		this.booknumber = booknumber;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getBookcontents() {
		return bookcontents;
	}
	public void setBookcontents(String bookcontents) {
		this.bookcontents = bookcontents;
	}
	public Double getBookrate() {
		return bookrate;
	}
	public void setBookrate(Double bookrate) {
		this.bookrate = bookrate;
	}
	public Integer getBooksale() {
		return booksale;
	}
	public void setBooksale(Integer booksale) {
		this.booksale = booksale;
	}
}
