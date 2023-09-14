package LibraryManagmentSystem;

import java.util.List;

public class Magazine extends Item
{
    private String publisher;
    private List<String> authorList;

    public String getPublisher()
    {
        return publisher;
    }

    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }

    public List<String> getAuthorList()
    {
        return authorList;
    }

    public void setAuthorList(List<String> authorList)
    {
        this.authorList = authorList;
    }

    @Override
    public int calculateCost()
    {
        return super.calculateCost();
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Magazine ID: "+this.getId());
        System.out.println("Magazine Tittle: "+this.getTittle());
        System.out.println("Magazine Authors: "+this.getAuthorList());
        System.out.println("Magazine Popularity Count: "+this.getPopularityCount());
        System.out.println("Magazine Price: "+this.getCost());
    }
}
