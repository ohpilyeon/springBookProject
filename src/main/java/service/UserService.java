package service;

import java.time.LocalDateTime;

import com.example.demo.UserRegisterRequest;

import dao.UserDao;
import dto.UserDto;

public class UserService {
	private UserDao userDao;
	public UserService(UserDao userDao) {
	    this.userDao = userDao;
    }
	public UserDto userSearch(String id) {
		UserDto searchUser = userDao.selectById(id);
		return searchUser;
	}
	public Boolean loginCheck(String id, String password) {
		UserDto userDto =userDao.selectById(id);
		if(userDto==null) return false;
		if(userDto.getPassword().equals(password)) return true;
		return false;
	}
	
	public String regist(UserRegisterRequest req) throws Exception {
        UserDto userDto = userDao.selectById(req.getId());
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
