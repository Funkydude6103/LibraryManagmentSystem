package LibraryManagmentSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

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
        int countID=1;
        for(String data:dataFromFile)
        {
            if(data.charAt(0)=='1')
            {
                Book book=new Book();
                String [] arr=data.split(", ");
                book.setTittle(arr[1]);
                book.setAuthor(arr[2]);
                book.setBorrowed(false);
                try
                {
                    book.setYear(Integer.parseInt(arr[3]));
                    book.setPopularityCount(Integer.parseInt(arr[4]));
                    book.setCost(Integer.parseInt(arr[5]));
                }
                catch (NumberFormatException e) {
                    System.out.println("Invalid input. Cannot parse to an integer.");
                }
                book.setId(countID);
                itemList.add(book);
                countID++;
            }
            if(data.charAt(0)=='2')
            {
                Magazine magazine=new Magazine();
                String [] arr=data.split(", ");
                magazine.setTittle(arr[1]);
                magazine.setBorrowed(false);
                int i=0;
                for(;i<data.length();i++)
                {
                    if(data.charAt(i)==',')
                    {
                        i++;
                        i++;
                        break;
                    }
                }
                for(;i<data.length();i++)
                {
                    if(data.charAt(i)==',')
                    {
                        i++;
                        i++;
                        break;
                    }
                }
                String author="";
                List<String> authors=new ArrayList<>();
                for (;i<data.length();i++)
                {
                    if(data.charAt(i)==',')
                    {
                        i++;
                        i++;
                        authors.add(author);
                        author="";
                    }
                    if(data.charAt(i)=='.')
                    {
                        authors.add(author);
                        i++;
                        i++;
                        i++;
                        break;
                    }
                    author=author+data.charAt(i);
                }
                magazine.setAuthorList(authors);
                author="";
                for (;i<data.length();i++)
                {
                    if(data.charAt(i)==',')
                    {
                       i++;
                       i++;
                       magazine.setPublisher(author);
                       break;
                    }
                    author=author+data.charAt(i);
                }
                author="";
                for (;i<data.length();i++)
                {
                    if(data.charAt(i)==',')
                    {
                        i++;
                        i++;
                        try
                        {
                            magazine.setPopularityCount(Integer.parseInt(author));
                        }
                        catch (NumberFormatException e) {
                            System.out.println(author+"Invalid input. Cannot parse to an integer.");
                        }
                        break;
                    }
                    author=author+data.charAt(i);
                }
                author="";
                for (;i<data.length();i++)
                {
                    author=author+data.charAt(i);
                }
                try
                {
                    magazine.setCost(Integer.parseInt(author));
                }
                catch (NumberFormatException e) {
                    System.out.println(author+"Invalid input. Cannot parse to an integer.");
                }
                magazine.setId(countID);
                itemList.add(magazine);
                countID++;
            }
            if(data.charAt(0)=='3')
            {
              Newspaper newspaper=new Newspaper();
                String [] arr=data.split(", ");
                newspaper.setTittle(arr[1]);
                newspaper.setPublisher(arr[2]);
                newspaper.setBorrowed(false);
                try
                {
                    newspaper.setPopularityCount(Integer.parseInt(arr[3]));
                }
                catch (NumberFormatException e) {
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
                newspaper.setId(countID);
                itemList.add(newspaper);
                countID++;
            }
        }


    }
}
