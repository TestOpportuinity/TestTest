/**
 * Created by Tomek on 2016-09-16.
 */
package model;

public class Author
{
    private Long id;
    private String ISBN;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getISBN()
    {
        return ISBN;
    }

    public void setISBN(String ISBN)
    {
        this.ISBN = ISBN;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Author - Id: " + id + ", ISBN :" + ISBN + ", Imię i Nazwisko: " + firstName + " " + lastName;
    }
}
