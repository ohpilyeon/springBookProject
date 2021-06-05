package dto;

import java.time.LocalDateTime;

public class BookDto {
	private int no;
	private String bookName;
	private String author;
	private String publishingHouse;
	private LocalDateTime publicationDate;
	private int price;
	private int currentCount;
	private int rentCount;

	public BookDto(int no, String bookName, String author, String publishingHouse, LocalDateTime publicationDate,
			int price, int currentCount, int rentCount) {
		super();
		this.no = no;
		this.bookName = bookName;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.publicationDate = publicationDate;
		this.price = price;
		this.currentCount = currentCount;
		this.rentCount = rentCount;
	}
	

	public BookDto(String bookName, String author, String publishingHouse, LocalDateTime publicationDate,
			int price, int currentCount, int rentCount) {
		this.bookName = bookName;
		this.author = author;
		this.publishingHouse = publishingHouse;
		this.publicationDate = publicationDate;
		this.price = price;
		this.currentCount = currentCount;
		this.rentCount = rentCount;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

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

	public int getCurrentCount() {
		return currentCount;
	}

	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}

	public int getRentCount() {
		return rentCount;
	}

	public void setRentCount(int rentCount) {
		this.rentCount = rentCount;
	}

}
