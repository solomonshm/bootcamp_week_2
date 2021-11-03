package bookshop.books;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAO {

    private ConfigurableApplicationContext context;
    private BookRepository repository;

    public void setup(String[] args) {
        System.out.println("BookDAO.setup()");
        context = SpringApplication.run(BookshopApp.class, args);
        repository = context.getBean(BookRepository.class);
    }

    public void shutdown() {

    }

    public Optional<Book> getBookByISBN(int isbn){
        System.out.printf("BookDAO.getBookByISBN(%s)\n", isbn);
        Optional<Book> book = null;


        // SELECT * FROM books WHERE isbn = 123;
        String sql = String.format("SELECT * FROM books WHERE isbn = %d", isbn);
        System.out.println(sql);
        book = repository.findById(isbn);
        return book;
    }

    public Iterable<Book> getAllBooks() {

        System.out.println("BookDAO.getAllBooks()");
        Iterable<Book> books = new ArrayList<>();

        String sql = "SELECT b FROM Book b";
        System.out.println(sql);

        books = repository.findAll();

        return books;
    }

    public void saveBook(Book book) {
        System.out.printf("BookDAO.saveBook(%s)\n", book);

        String sql = String.format(
                "INSERT INTO books (isbn, title, category, author) VALUES(%d, '%s', '%s', '%s')",
                book.getIsbn(),
                book.getTitle(),
                book.getCategory(),
                book.getAuthor());

        System.out.println(sql);

        repository.save(book);

    }

    public void deleteBook(Book book) {
        System.out.printf("BookDAO.deleteBook(%s)\n", book);
        String sql = "DELETE FROM books WHERE isbn = '" + book.getIsbn() + "'";
        System.out.println(sql);
        repository.delete(book);
    }


}
