package org.gl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book")
public class Book {

	public Book() {
		
	}
	
	public Book(String bookName, String authorName, String description, double price, String genre,int sell)
	{
		this.bookName = bookName;
		this.authorName = authorName;
		this.description = description;
		this.price = price;
		this.genre = genre;
		this.sell = sell;
	}
	



	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "bookId")
	private int bookId;
	
	@Column(name = "bookName")
	private String bookName;
	
	@Column(name = "authorName")
	private String authorName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "genre")
	private String genre;
	 
	@Column(name = "sell")
	private int sell;
	
	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + ", description="
				+ description + ", price=" + price + ", genre=" + genre + ", sell=" + sell + "]";
	}

	

	

	
}
