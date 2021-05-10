package com.examly.springapp.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LibraryBook {
	
	@Id
	private String bookId;
	private String quantity;
	private String bookName;
	private String genre;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "LibraryController [bookId=" + bookId + ", quantity=" + quantity + ", bookName=" + bookName + ", genre="
				+ genre + "]";
	}
}
