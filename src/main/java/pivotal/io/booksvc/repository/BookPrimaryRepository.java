package pivotal.io.booksvc.repository;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import pivotal.io.booksvc.domain.BookDetails;

@Repository
public class BookPrimaryRepository {
	
	private final JdbcTemplate jdbcTemplate;
	
	private final String SQL_QUERY_BY_ISBN = "select * from book where isbn=?";
	private final String SQL_QUERY_ALL = "select * from book";
	
	private final RowMapper<BookDetails> rowMapper = (ResultSet rs, int row) -> {
		BookDetails book = new BookDetails();
		book.setIsbn(rs.getString("isbn"));
		book.setTitle(rs.getString("title"));
		book.setPageCount(rs.getInt("pages"));
		book.setSource("PRIMARY");
		return book;
	};
	
	public BookPrimaryRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public BookDetails findByIsbn(String isbn) {
		// Fake some latency
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}
        return this.jdbcTemplate.queryForObject(SQL_QUERY_BY_ISBN, new Object[]{isbn}, rowMapper);

	}
	
	public List<BookDetails> findAll() {
        return this.jdbcTemplate.query(SQL_QUERY_ALL, rowMapper);
	}
}
