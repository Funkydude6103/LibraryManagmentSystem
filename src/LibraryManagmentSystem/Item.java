package LibraryManagmentSystem;

public class Item implements Configuration
{
    private String tittle;
    private boolean isBorrowed;
    private int popularityCount;
    private int id;
    private int cost;

    public int getCost()
    {
        return cost;
    }

    public String getTittle()
    {
        return tittle;
    }

    public void setTittle(String tittle)
    {
        this.tittle = tittle;
    }

    public boolean isBorrowed()
    {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed)
    {
        isBorrowed = borrowed;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getPopularityCount()
    {
        return popularityCount;
    }

    public void setPopularityCount(int popularityCount)
    {
        this.popularityCount = popularityCount;
    }

    public void setCost(int cost)
    {
        this.cost = cost;
    }
    @Override
    public void displayInfo()
    {

    }
    @Override
    public int calculateCost()
    {
        return 0;
    }
}
