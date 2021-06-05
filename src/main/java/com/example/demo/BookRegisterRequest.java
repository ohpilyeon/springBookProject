package com.example.demo;

import java.time.LocalDateTime;

public class BookRegisterRequest {
	private String bookName;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishingHouse() {
		return publishingHouse;
	}
	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}
	public LocalDateTime getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(LocalDateTime publicationDate) {
		this.publicationDate = publicationDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	private String author;
	private String publishingHouse;
	private LocalDateTime publicationDate;
	private int price;
	private int currentCount;
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public void setPublicationDateByYMD(String year, String month, String day) {
		this.publicationDate=LocalDateTime.of(Integer.valueOf(year), Integer.valueOf(month),Integer.valueOf(day),0,0,0);
	}
}
