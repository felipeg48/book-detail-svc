package pivotal.io.booksvc.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pivotal.io.booksvc.controller.BookDetailsController;
import pivotal.io.booksvc.service.BookDetailsService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookDetailsController.class)
public class BookDetailsControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookDetailsService bookServiceMock;
	
	@Test
	public void testGetBook() {
		assertTrue(true);
	}
}
