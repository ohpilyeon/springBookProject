package dto;

import java.time.LocalDateTime;

public class RentDto {
	private int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public LocalDateTime getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDateTime rentDate) {
		this.rentDate = rentDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	private String id;
	private String bookName;
	private LocalDateTime rentDate;
	private LocalDateTime returnDate;
	public RentDto(int no, String id, String bookName, LocalDateTime rentDate, LocalDateTime returnDate) {
		this.no=no;
		this.id=id;
		this.bookName=bookName;
		this.rentDate=rentDate;
		this.returnDate=returnDate;
	}
	public RentDto(String id, String bookName, LocalDateTime rentDate, LocalDateTime returnDate) {
		this.id=id;
		this.bookName=bookName;
		this.rentDate=rentDate;
		this.returnDate=returnDate;
	}
	public RentDto(String id, String bookName, LocalDateTime rentDate) {
		this.id=id;
		this.bookName=bookName;
		this.rentDate=rentDate;
		this.returnDate=rentDate.plusWeeks(1);
	}
}
