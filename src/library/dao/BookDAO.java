/**
 * Created by Tomek on 2016-09-16.
 */
package library.dao;

import java.util.List;

import library.model.Book;
import library.model.Category;

public interface BookDAO
{
    List<Book>findAllBooks();

    List<Book>searchBooksByKeyword(String keyWord);

    List<Category>findAllCategories();

    void insert(Book book);
    void update(Book book);
    void delete(String ISBN);
}
