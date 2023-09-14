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
        System.out.println("Book ID: "+this.getId());
        System.out.println("Book Tittle: "+this.getTittle());
        System.out.println("Book Author: "+this.getAuthor());
        System.out.println("Book Year: "+this.getYear());
        System.out.println("Book's Popularity Count: "+this.getPopularityCount());
        System.out.println("Book Price: "+this.getCost());
    }

    @Override
    public int calculateCost()
    {
        return super.calculateCost();
    }
}
