package dao;

import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.jdbc.core.*;

import dto.UserDto;

public class UserDao {
	private JdbcTemplate jdbcTemplate;

	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<UserDto> selectAll() {
		List<UserDto> results = jdbcTemplate.query("select * from USER", (ResultSet rs, int rowNum) -> {
			UserDto userDto = new UserDto(rs.getString("ID"), rs.getString("EMAIL"), rs.getString("PASSWORD"),
					rs.getString("NAME"), rs.getString("PHONENUMBER"),rs.getTimestamp("REGDATE").toLocalDateTime());
			return userDto;
		});
		return results;
	}
	public void update(UserDto userDto) {
		jdbcTemplate.update("update USER set NAME = ?, PASSWORD =?" + " where EMAIL = ?", userDto.getName(),
				userDto.getPassword(), userDto.getEmail());
	}
	public UserDto selectByEmail(String email) {
		List<UserDto> results = jdbcTemplate.query("select * from USER where EMAIL = ?", new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto userDto = new  UserDto(rs.getString("id"),rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),rs.getString("PHONENUMBER"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				userDto.setId(rs.getString("ID"));
				return userDto;
			}
		}, email);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public UserDto selectById(String id) {
		List<UserDto> results = jdbcTemplate.query("select * from USER where ID = ?",new RowMapper<UserDto>() {
			@Override
			public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDto userDto = new UserDto(rs.getString("id"),rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),rs.getString("PHONENUMBER"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				//UserDto.setId(rs.getLong("ID"));
				return userDto;
			}
		}, id);
		return results.isEmpty() ? null : results.get(0);
	}
	

	public void delete(final UserDto userDto) {
		jdbcTemplate.update("delete from USER where id = ?",userDto.getId());
	}
	public void insert(final UserDto userDto) {
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update("insert into USER (ID,EMAIL,PASSWORD,NAME,PHONENUMBER,REGDATE) "+"values(?,?,?,?,?,?)",userDto.getId(),userDto.getEmail(),userDto.getPassword(),userDto.getName(),userDto.getPhoneNumber(),userDto.getRegisterDateTime());
	}
	public void regist(final UserDto userDto) {
		//KeyHolder keyHolder = new GeneratedKeyHolder();
		System.out.println("regist iN");
		jdbcTemplate.update("insert into USER (ID,EMAIL,PASSWORD,NAME,PHONENUMBER,REGDATE) values(?,?,?,?,?,?)",userDto.getId(),userDto.getEmail(),userDto.getPassword(),userDto.getName(),userDto.getPhoneNumber(),userDto.getRegisterDateTime());
	}
}