/**
 * Created by Tomek on 2016-09-17.
 */
package main;

import dao.BookDAO;
import dao.BookDAOImplementation;
import model.Book;

import java.util.List;


public class BookApp
{
    private static BookDAO bookDAO = new BookDAOImplementation();

    public static void main(String[] args)
    {
        System.err.println("Lista wszystkich książek");
        findAllBooks();
        System.out.println();

        System.err.println("wyszukiwanie książek ze słowem kluczowym 'Java' w nazwie:");
        searchBooks("Java");
        System.out.println();

    }

    private static void findAllBooks()
    {
        List<Book> books = bookDAO.findAllBooks();
        for(Book book : books)
        {
            System.out.println(book);
        }
    }

    private static void searchBooks(String keyWord)
    {
        List<Book> books = bookDAO.searchBooksByKeyword(keyWord);
        for(Book book : books)
        {
            System.out.println(book);
        }
    }
}
