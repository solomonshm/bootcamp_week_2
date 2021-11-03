package bookshop.books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Bookshop {

	private BookRepository repository;

	public Bookshop()  throws SQLException {
	}

	public Iterable<Book> getBooks() throws SQLException {
		return repository.findAll();
	}

	public Iterable<Book> getAllBooks() throws SQLException {
		return repository.findAll();
	}

	public Optional<Book> getBookByISBN(int isbn) throws SQLException {
		return repository.findById(isbn);
	}

	public void saveBook(Book book) throws SQLException {
		repository.save(book);
	}

	public void deleteBook(Book book) throws SQLException {
		repository.delete(book);
	}


}
