/**
 * Created by Tomek on 2016-09-16.
 * bookDAO implementation
 */
package library.dao;

import library.model.Author;
import library.model.Book;
import library.model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImplementation implements BookDAO
{
    static{
            try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                }
                catch (ClassNotFoundException ex)
                {
                    ex.printStackTrace(System.out);
                }
        }

        private Connection getConnection() throws SQLException
        {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","" );
        }

        private void cloesConnection(Connection connection)
        {
            if(connection == null)
            {
                return;
            }
            try
            {
                connection.close();
            }
            catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }

    public List<Book>findAllBooks()
        {
            List<Book> result = new ArrayList<>();
            List<Author> authorList = new ArrayList<>();

            String sql = "SELECT * FROM book INNER JOIN author ON book.author_ID = author.ID";

            Connection connection = null;

            try
            {
                connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    Book book = new Book();
                    Author author = new Author();
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                    book.setCategoryId(resultSet.getLong("CATEGORY_ID"));
                    author.setFirstName(resultSet.getString("firstName"));
                    author.setLastName(resultSet.getString("lastName"));
                    authorList.add(author);
                    book.setAuthors(authorList);
                    book.setPublisherName(resultSet.getString("PUBLISHER"));
                    result.add(book);
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                cloesConnection(connection);
            }
            return result;
        }

        public List<Book> searchBooksByKeyword(String keyWord)
        {
            List<Book> result = new ArrayList<>();
            List<Author> authorList = new ArrayList<>();

            String sql = "SELECT * FROM book INNER JOIN author ON book.author_ID = author.ID "
                        + "WHERE book.BOOK_TITLE LIKE '%" + keyWord.trim() + "%'"
                        + "OR author.firstName LIKE '%" + keyWord.trim() + "%'"
                        + "OR author.lastName LIKE '%" + keyWord.trim() + "%'";

            Connection connection = null;

            try
            {
                connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    Book book = new Book();
                    library.model.Author author = new library.model.Author();
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setBookTitle(resultSet.getString("BOOK_TITLE"));
                    book.setCategoryId(resultSet.getLong("CATEGORY_ID"));
                    author.setFirstName(resultSet.getString("firstName"));
                    author.setLastName(resultSet.getString("lastName"));
                    authorList.add(author);
                    book.setAuthors(authorList);
                    book.setPublisherName(resultSet.getString("PUBLISHER"));
                    result.add(book);
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                cloesConnection(connection);
            }
            return result;
        }

        public List<Category> findAllCategories()
        {
            List<Category> result = new ArrayList<>();
            String sql = "SELECT * FROM category";

            Connection connection = null;

            try
            {
                connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    Category category = new Category();
                    category.setId(resultSet.getLong("ID"));
                    category.setCategoryName(resultSet.getString("CATEGORY_NAME"));
                    result.add(category);
                }
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            finally
            {
                cloesConnection(connection);
            }
            return result;
        }

    @Override
    public void insert(Book book)
    {

    }

    @Override
    public void update(Book book)
    {

    }

    @Override
    public void delete(String ISBN)
    {

    }
}
