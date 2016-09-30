/**
 * Created by Tomek on 2016-09-16.
 */
package library.model;

public class Category
{
    private Long Id;
    private String categoryName;

    public Long getId()
    {
        return Id;
    }

    public void setId(Long Id)
    {
        this.Id = Id;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String toString()
    {
        return "Kategoria - Identyfikator: " + Id + ", Nazwa Kategorii" + categoryName;
    }
}
