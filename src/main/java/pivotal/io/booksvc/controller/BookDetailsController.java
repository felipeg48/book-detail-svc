package pivotal.io.booksvc.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pivotal.io.booksvc.domain.BookDetails;
import pivotal.io.booksvc.service.BookDetailsService;

@RestController
@RequestMapping("/bookdetails")
public class BookDetailsController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookDetailsController.class);
	
	private BookDetailsService bookService;
	
	public BookDetailsController(BookDetailsService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{isbn}")
	public BookDetails getBookDetails(@PathVariable String isbn) {
		logger.info("Finding book for isbn: {}", isbn);
		return bookService.findFromPrimary(isbn);
	}
	
	@GetMapping
	public List<BookDetails> getAllBookDetails() {
		return bookService.findAll();
	}
	
}
