package service;

import java.time.LocalDateTime;

import com.example.demo.UserRegisterRequest;

import dao.UserDao;
import dto.UserDto;

public class UserRegisterService {
	 private UserDao userDao;

	    public UserRegisterService(UserDao userDao) {
	        this.userDao = userDao;
	    }

	    public String regist(UserRegisterRequest req) throws Exception {
	        UserDto userDto = userDao.selectByEmail(req.getId());
	        if (userDto != null) {
	            throw new Exception("DuplicateUserException");
	        }
	        if(!req.isPasswordEqualToConfirmPassword()) {
	        	throw new Exception("isPasswordEqualToConfirmPasswordException");
	        }
	        UserDto newUser = new UserDto(req.getId(), req.getEmail(), req.getPassword(), 
					req.getName(), req.getPhoneNumber(),LocalDateTime.now());
	        userDao.regist(newUser);
	        return newUser.getId();
	    }
}
