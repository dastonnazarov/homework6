package library.service;

import library.controller.AdminController;
import library.dto.Book;
import library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AdminController adminController;

    public void addBook(Book book) {
        Book exist = bookRepository.getBookById(book.getId());
        if (exist != null) {
            System.out.println("sorry that book already exist!!!");
            adminController.adminSectionMenu();

        } else {
            book.setPublishYear(LocalDate.now());
            bookRepository.addBook(book);
            System.out.println("Book is create successfully");
        }
    }

    public void bookList() {
        System.out.println("------------------      book   list    -----------------------");
        List<Book> bookList = bookRepository.getBookList();
        bookList.forEach(book -> System.out.println(book));
        adminController.adminSectionMenu();
    }

    public void deleteBook(Book book) {
        Book exist = bookRepository.getBookById(book.getId());
        if (exist == null) {
            System.out.println("not fount!!!");
            adminController.adminSectionMenu();
        }else {
            bookRepository.deleteBook(book.getId());
            System.out.println("book deleted successfully ");
            adminController.adminSectionMenu();
        }
    }
}
