package service;

import java.time.LocalDateTime;

import com.example.demo.UserRegisterRequest;

import dao.UserDao;
import dto.UserDto;

public class UserDeleteService {
	 private UserDao userDao;

	    public UserDeleteService(UserDao userDao) {
	        this.userDao = userDao;
	    }

	    public String delete(UserRegisterRequest req) throws Exception {
	        UserDto userDto = userDao.selectById(req.getId());
	        if (userDto == null) {
	            throw new Exception("NotExistUserException");
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
