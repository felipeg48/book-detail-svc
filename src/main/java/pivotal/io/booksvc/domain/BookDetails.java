package pivotal.io.booksvc.domain;

public class BookDetails {
	public String isbn;
	public String title;
	public Integer pageCount;
	public String source;

	public BookDetails() {
		
	}

	public BookDetails(String isbn, String title, Integer pageCount) {
		this.isbn = isbn;
		this.title = title;
		this.pageCount = pageCount;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
}
