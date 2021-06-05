package service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.BookRegisterRequest;

import dao.RentDao;
import dto.BookDto;
import dto.RentDto;

public class RentService {
	private RentDao rentDao;

    public RentService(RentDao rentDao) {
        this.rentDao = rentDao;
    }
    
    public List<RentDto> getAllRentList() {
    	return rentDao.selectAll();
    }
    public Boolean addRent(String id, String bookName){
    	int check=0;
        List<RentDto> rentList = rentDao.selectByBookName(bookName);
        for(RentDto rentDto : rentList) {
        	if(rentDto!=null) {
        		if(rentDto.getId().equals(id)) {
        			check=1;
        		}
        	}
        }
        if(check==0) {
        	RentDto newRent = new RentDto(id,bookName,LocalDateTime.now(),LocalDateTime.now().plusWeeks(1));
        	rentDao.insert(newRent);
        	return true;
        }
        return false;
    }
    public Boolean deleteRent(String id, String bookName){
        List<RentDto> rentList = rentDao.selectByBookName(bookName);
        RentDto delRent=null;
        for(RentDto rentDto : rentList) {
        	if(rentDto!=null) {
        		if(rentDto.getId().equals(id)) {
        			delRent=rentDto;
        		}
        	}
        }
        if(delRent!=null) {
        	rentDao.delete(delRent);
        	return true;
        }
        return false;
    }
    
}
