package dto;

import java.time.LocalDateTime;

public class UserDto {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getRegisterDateTime() {
		return registerDateTime;
	}

	public void setRegisterDateTime(LocalDateTime registerDateTime) {
		this.registerDateTime = registerDateTime;
	}

	private String id;
	private String email;
	private String password;
	private String name;
	private String phoneNumber;
	private LocalDateTime registerDateTime;
	
	public UserDto(String id, String email, String password, String name, String phoneNumber,LocalDateTime registerDateTime) {
		this.id=id;
		this.email=email;
		this.password=password;
		this.name=name;
		this.phoneNumber=phoneNumber;
		this.registerDateTime=registerDateTime;
	}
	
}
