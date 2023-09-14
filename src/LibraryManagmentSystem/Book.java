package LibraryManagmentSystem;

public class Book extends Item
{
    private String author;
    private int year;

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    @Override
    public void displayInfo()
    {
        super.displayInfo();
    }

    @Override
    public int calculateCost()
    {
        return super.calculateCost();
    }
}
