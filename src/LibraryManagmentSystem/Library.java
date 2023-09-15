package LibraryManagmentSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Library
{
    public Library()
    {
        itemList=new ArrayList<>();
    }
    private List<Item> itemList;

    public void displayAllItems()
    {
        int count=1;
        for(Item item:itemList)
        {
            System.out.println("Item "+count+"#");
            item.displayInfo();
            System.out.println();
            count++;
        }
        System.out.println("Enter 0 to return to Main Menu");
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            String choice=scanner.nextLine();
            if(choice.equals("0"))
            {
                break;
            }
        }
    }
    public void loadFromFile()
    {
        Vector<String> dataFromFile=new Vector<String>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Tayyab Anees\\OneDrive\\Desktop\\LibraryManagmentSystem\\src\\LibraryManagmentSystem\\data.txt")))
        {
            String line;
            while ((line = br.readLine()) != null)
            {
                dataFromFile.add(line);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        for(String data:dataFromFile)
        {
            //Book Case
            if(data.charAt(0)=='1')
            {
                Book book=new Book();
                String [] arr=data.split(", ");
                if(arr.length>=6)
                {
                    book.setTittle(arr[1]);
                    book.setAuthor(arr[2]);
                    book.setBorrowed(false);
                    try {
                        book.setYear(Integer.parseInt(arr[3]));
                        book.setPopularityCount(Integer.parseInt(arr[4]));
                        book.setCost(Integer.parseInt(arr[5]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Cannot parse to an integer.");
                    }
                    book.setId(Item.getNextId());
                    book.incrementNextId();
                    itemList.add(book);
                }

            }
            //Magazine Case
            if(data.charAt(0)=='2')
            {
                Magazine magazine=new Magazine();
                String [] arr=data.split(", ");
                if(arr.length>=6)
                {
                    magazine.setTittle(arr[1]);
                    magazine.setBorrowed(false);
                    List<String> authors = new ArrayList<>(Arrays.asList(arr).subList(2, arr.length - 4));
                    authors.add(arr[arr.length-4].substring(0,arr[arr.length-4].length()-1));
                    magazine.setAuthorList(authors);
                    magazine.setPublisher(arr[arr.length - 3]);

                    try {
                        magazine.setPopularityCount(Integer.parseInt(arr[arr.length - 2]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Cannot parse to an integer.");
                    }
                    try {
                        magazine.setCost(Integer.parseInt(arr[arr.length - 1]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Cannot parse to an integer.");
                    }
                    magazine.setId(Item.getNextId());
                    magazine.incrementNextId();
                    itemList.add(magazine);
                }
            }
            //Newspaper Case
            if(data.charAt(0)=='3')
            {
              Newspaper newspaper=new Newspaper();
                String [] arr=data.split(", ");
                if(arr.length>=4)
                {
                    newspaper.setTittle(arr[1]);
                    newspaper.setPublisher(arr[2]);
                    newspaper.setBorrowed(false);
                    try {
                        newspaper.setPopularityCount(Integer.parseInt(arr[3]));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Cannot parse to an integer.");
                    }
                    String dateString = arr[4];
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        Date date = dateFormat.parse(dateString);
                        newspaper.setDate(date);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("Invalid date format.");
                    }
                    newspaper.setId(Item.getNextId());
                    newspaper.incrementNextId();
                    itemList.add(newspaper);
                }
            }
        }


    }
    public void displaySingleItem(Item i)
    {
       i.displayInfo();
    }
    public Item getItemById(int id)
    {
        return itemList.get(id-1);
    }
}
