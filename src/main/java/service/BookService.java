package service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.BookRegisterRequest;
import com.example.demo.UserRegisterRequest;

import dao.BookDao;
import dto.BookDto;
import dto.UserDto;

public class BookService {
	private BookDao bookDao;

    public BookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }
    
    public List<BookDto> getAllBookList() {
    	return bookDao.selectAll();
    }
    public String addBook(BookRegisterRequest req){
        BookDto bookDto = bookDao.selectBookByBookName(req.getBookName());
        if (bookDto != null) {
        	bookDao.currentCountPlus(bookDto, 1);
        	return bookDto.getBookName();
        }
       	BookDto newBook = new BookDto(req.getBookName(),req.getAuthor(),req.getPublishingHouse(),req.getPublicationDate(),req.getPrice(),1,0);
       	bookDao.insert(newBook);
        return newBook.getBookName();
    }

}
