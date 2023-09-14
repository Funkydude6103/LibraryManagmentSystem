import LibraryManagmentSystem.Library;
public class Main {
    public static void main(String[] args)
    {
        Library library=new Library();
        library.loadFromFile();
        library.displayAllItems();
    }
}