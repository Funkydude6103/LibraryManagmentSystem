package LibraryManagmentSystem;

import java.util.Date;

public class Newspaper extends Item
{
 private String publisher;
 private Date date;

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    @Override
    public int calculateCost()
    {
        return super.calculateCost();
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Newspaper ID: "+this.getId());
        System.out.println("Newspaper Tittle: "+this.getTittle());
        System.out.println("Newspaper Publisher: "+this.getPublisher());
        System.out.println("Newspaper Popularity Count: "+this.getPopularityCount());
        System.out.println("Newspaper Date: "+this.getDate());
    }
}
