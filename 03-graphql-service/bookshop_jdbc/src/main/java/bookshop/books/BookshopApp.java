package bookshop.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.sql.SQLException;

@SpringBootApplication
public class BookshopApp {
    public static void main(String [] args)  {
        System.out.println("Starting Bookshop setup");
        ConfigurableApplicationContext context = SpringApplication.run(BookshopApp.class, args);
        System.out.println("Setup finished");

        Bookshop bookshop = context.getBean(Bookshop.class);
        try {
            System.out.println(bookshop.getBooks());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Book b1 = null;
        try {
            b1 = bookshop.getBookByISBN(2).get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b1);

        Book b2 = new Book(7, "Java For Professionals", "Technical", "John Anders");
        try {
            bookshop.saveBook(b2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(bookshop.getBooks());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            bookshop.deleteBook(b2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(bookshop.getBooks());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}