package dao;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import dto.RentDto;

public class RentDao {
	private JdbcTemplate jdbcTemplate;

	public RentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public List<RentDto> selectAll() {
		List<RentDto> results = jdbcTemplate.query("select * from RENT", (ResultSet rs, int rowNum) -> {
			RentDto rentDto = new RentDto(rs.getString("ID"), rs.getString("BOOKNAME"), rs.getTimestamp("RENTDATE").toLocalDateTime(),
					rs.getTimestamp("RETURNDATE").toLocalDateTime());
			return rentDto;
		});
		return results;
	}
	public List<RentDto> selectByUser(String userId) {
		List<RentDto> results = jdbcTemplate.query("select * from RENT where id = ?", (ResultSet rs, int rowNum) -> {
			RentDto rentDto = new RentDto(rs.getString("ID"), rs.getString("BOOKNAME"), rs.getTimestamp("RENTDATE").toLocalDateTime(),
					rs.getTimestamp("RETURNDATE").toLocalDateTime());
			return rentDto;
		},userId);
		return results;
	}
	public List<RentDto> selectByBookName(String bookName) {
		List<RentDto> results = jdbcTemplate.query("select * from RENT where BOOKNAME = ?", (ResultSet rs, int rowNum) -> {
			RentDto rentDto = new RentDto(rs.getString("ID"), rs.getString("BOOKNAME"), rs.getTimestamp("RENTDATE").toLocalDateTime(),
					rs.getTimestamp("RETURNDATE").toLocalDateTime());
			return rentDto;
		},bookName);
		return results;
	}
	public void insert(final RentDto rentDto) {
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		rentDto.setReturnDate(rentDto.getRentDate().plusWeeks(1));
		//일주일 변경.
		jdbcTemplate.update("insert into RENT (ID,BOOKNAME,RENTDATE,RETURNDATE) "+"values(?,?,?,?)",rentDto.getId(),rentDto.getBookName(),rentDto.getRentDate(),rentDto.getReturnDate());
	}
	public void delete(final RentDto rentDto) {
		jdbcTemplate.update("delete from RENT where id = ? AND where BOOKNAME = ?",rentDto.getNo());
	}

}
