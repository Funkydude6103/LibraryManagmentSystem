package LibraryManagmentSystem;

public class Item implements Configuration
{
    private String tittle;
    private boolean isBorrowed;
    private int popularityCount;
    private static int id;
    private int cost;

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
