package pivotal.io.booksvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import pivotal.io.booksvc.domain.BookDetails;
import pivotal.io.booksvc.repository.BookPrimaryRepository;
import pivotal.io.booksvc.repository.BookSecondaryRepository;

@Service
public class BookDetailsService {
	
	private final BookPrimaryRepository primaryRepo;
	private final BookSecondaryRepository secondaryRepo;
	
	public BookDetailsService(BookPrimaryRepository primaryRepo, BookSecondaryRepository secondaryRepo) {
		this.primaryRepo = primaryRepo;
		this.secondaryRepo = secondaryRepo;
	}
	
	@HystrixCommand(fallbackMethod = "findFromSecondary")
	public BookDetails findFromPrimary(String isbn) {
		return primaryRepo.findByIsbn(isbn);
	}
	
	@HystrixCommand(
			fallbackMethod = "defaultBook", 
			threadPoolKey = "SecondaryFallback", // Use a separate thread pool for the fallback method
			commandProperties = {
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")}
	)
	public BookDetails findFromSecondary(String isbn) {
		return secondaryRepo.findByIsbn(isbn);
	}
	
	public BookDetails defaultBook(String isbn) {
		return new BookDetails("12345","Default Book", 1);
	}
	
	public List<BookDetails> findAll() {
		return primaryRepo.findAll();
	}
}
