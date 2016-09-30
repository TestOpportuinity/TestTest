/**
 * Created by Tomek on 2016-09-16.
 */
package dao;

import model.Author;
import model.Book;
import model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
                {}
        }

        private Connection getConnection() throws SQLException
        {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bibilioteka?","root","biblioteka" );
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
            {}
        }

    public List<model.Book>findAllBooks()
        {
            List<model.Book> result = new ArrayList<>();
            List<Author> authorList = new ArrayList<>();

            String sql = "SELECT * FROM ksiazka INNER JOIN autor ON ksiazka.ISBN = autor.ISBN";

            Connection connection = null;

            try
            {
                connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    model.Book book = new model.Book();
                    Author author = new Author();
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setBookTitle(resultSet.getString("tytul"));
                    book.setCategoryId(resultSet.getLong("ID_kategorii"));
                    author.setISBN(resultSet.getString("ISBN"));
                    author.setFirstName(resultSet.getString("imie"));
                    author.setLastName(resultSet.getString("nazwisko"));
                    authorList.add(author);
                    book.setAuthors(authorList);
                    book.setPublisherName(resultSet.getString("wydawca"));
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

        public List<model.Book> searchBooksByKeyword(String keyWord)
        {
            List<model.Book> result = new ArrayList<>();
            List<Author> authorList = new ArrayList<>();

            String sql = "SELECT * FROM ksiazka INNER JOIN autor ON ksiazka.ISBN = autor.ISBN"
                        + "WHERE tytul LIKE '%" + keyWord.trim() + "%'"
                        + "OR imie LIKE '%" + keyWord.trim() + "%'"
                        + "OR nazwisko LIKE '%" + keyWord.trim() + "%'";

            Connection connection = null;

            try
            {
                connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next())
                {
                    model.Book book = new model.Book();
                    model.Author author = new model.Author();
                    book.setISBN(resultSet.getString("ISBN"));
                    book.setBookTitle(resultSet.getString("tytul"));
                    book.setCategoryId(resultSet.getLong("ID_kategorii"));
                    author.setISBN(resultSet.getString("ISBN"));
                    author.setFirstName(resultSet.getString("imie"));
                    author.setLastName(resultSet.getString("nazwisko"));
                    authorList.add(author);
                    book.setAuthors(authorList);
                    book.setPublisherName(resultSet.getString("wydawca"));
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
            String sql = "SELECT * FROM kategoria";

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
                    category.setCategoryName(resultSet.getString("nazwa"));
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
    public void insert(model.Book book)
    {

    }

    @Override
    public void update(model.Book book)
    {

    }

    @Override
    public void delete(String ISBN)
    {

    }
}
