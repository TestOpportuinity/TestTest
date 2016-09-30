/**
 * Created by Tomek on 2016-09-16.
 */
package library.model;

import java.util.List;

public class Book
{
    private String ISBN;
    private Long categoryId;
    private String bookTitle;
    private List<Author> authors;
    private String publisherName;

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public Long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(Long categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }

    public List<Author> getAuthors()
    {
        return authors;
    }

    public void setAuthors(List<Author> authors)
    {
        this.authors = authors;
    }

    public String getPublisherName()
    {
        return publisherName;
    }

    public void setPublisherName(String publisherName)
    {
        this.publisherName = publisherName;
    }

    public String toString()
    {
        return "Książka - Identyfikator: " + ISBN + ",tytuł :" + bookTitle;
    }
}