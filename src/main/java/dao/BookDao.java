package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dto.BookDto;

public class BookDao {
	private JdbcTemplate jdbcTemplate;

	public BookDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<BookDto> selectAll() {
		List<BookDto> results = jdbcTemplate.query("select * from BOOK", (ResultSet rs, int rowNum) -> {
			BookDto bookDto = new BookDto(rs.getInt("NO"), rs.getString("BOOKNAME"), rs.getString("AUTHOR"),
					rs.getString("PUBLISHINGHOUSE"), rs.getTimestamp("PUBLICATIONDATE").toLocalDateTime(),
					rs.getInt("PRICE"), rs.getInt("CURRENTCOUNT"), rs.getInt("RENTCOUNT"));
			System.out.println(rs.getString("PUBLISHINGHOUSE"));
			return bookDto;
		});
		return results;
	}
	public void currentCountPlus(BookDto currentBook, int count) {
		int plusCount = currentBook.getCurrentCount()+count;
		jdbcTemplate.update("update BOOK set CURRENTCOUNT = ?" + " where BOOKNAME = ?", plusCount,currentBook.getBookName());
	}
	public void insert(final BookDto bookDto) {
		jdbcTemplate.update("insert into BOOK (BOOKNAME,AUTHOR,PUBLISHINGHOUSE,PUBLICATIONDATE,PRICE,CURRENTCOUNT,RENTCOUNT) "+"values(?,?,?,?,?,?,?)",bookDto.getBookName(),bookDto.getAuthor(),bookDto.getPublishingHouse(),bookDto.getPublicationDate(),bookDto.getPrice(),bookDto.getCurrentCount(),bookDto.getRentCount());
	}

	public BookDto selectBookByBookName(String bookName) {
		List<BookDto> result = jdbcTemplate.query("select * from BOOK where BOOKNAME = ?",new RowMapper<BookDto>() {
			@Override
			public BookDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				BookDto bookDto = new BookDto(rs.getInt("NO"), rs.getString("BOOKNAME"), rs.getString("AUTHOR"),
						rs.getString("PUBLISHINGHOUSE"), rs.getTimestamp("PUBLICATIONDATE").toLocalDateTime(),
						rs.getInt("PRICE"), rs.getInt("CURRENTCOUNT"), rs.getInt("RENTCOUNT"));
				return bookDto;
			}
		}, bookName);
		return result.isEmpty() ? null : result.get(0);
	}

}
