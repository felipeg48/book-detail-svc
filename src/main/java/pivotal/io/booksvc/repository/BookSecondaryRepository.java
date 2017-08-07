package pivotal.io.booksvc.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pivotal.io.booksvc.domain.BookDetails;

@Repository
public class BookSecondaryRepository {
	private final Map<String, BookDetails> bookMap = new HashMap<String, BookDetails>() {{
		put("978-1-4493-7464-8", new BookDetails("978-1-4493-7464-8", "Cloud Native Java (map)", 628));
		put("978-1-4919-3243-8", new BookDetails("978-1-4919-3243-8", "Cloud Foundry: The Definitive Guide (map)", 324));
		put("978-0134434421", new BookDetails("978-0134434421", "Domain-Driven Design Distilled (map)", 176));
	}};

	public BookDetails findByIsbn(String isbn) {
		// Fake some latency
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
		}
		return bookMap.get(isbn);
	}
}
