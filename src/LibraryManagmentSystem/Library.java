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
        for(Item item:itemList)
        {
            if(item.getId()==id)
                return item;
        }
        return null;
    }
    public void addItem()
    {
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter 1 for Book");
            System.out.println("Enter 2 for Magazine");
            System.out.println("Enter 3 for Newspaper");
            System.out.println("Enter 0 to return to Main Menu");
            System.out.println("Select the Item: ");
            String choice2 = scanner.nextLine();
            if(choice2.equals("1"))
            {
                Book book=new Book();
                book.setBorrowed(false);
                book.setId(Item.getNextId());
                book.incrementNextId();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter Tittle of Book: ");
                String input = scanner.nextLine();
                book.setTittle(input);
                System.out.println("Enter the Author of Book: ");
                input = scanner.nextLine();
                book.setAuthor(input);
                System.out.println("Enter the Published year of Book: ");
                int input2=scanner2.nextInt();
                book.setYear(input2);
                System.out.println("Enter the Popularity Count of Book: ");
                input2=scanner2.nextInt();
                book.setPopularityCount(input2);
                System.out.println("Enter the Cost of Book: ");
                input2=scanner2.nextInt();
                book.setCost(input2);
                itemList.add(book);
                System.out.println("Item Added!!!!");
            }
            if(choice2.equals("2"))
            {
                Magazine magazine=new Magazine();
                magazine.setBorrowed(false);
                magazine.setId(Item.getNextId());
                magazine.incrementNextId();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter Tittle of Magazine: ");
                String input = scanner.nextLine();
                magazine.setTittle(input);
                System.out.println("Enter the Authors of Book and Enter 0 to exit entering Authors: ");
                List<String> authors=new ArrayList<>();
                while(true)
                {
                    input = scanner.nextLine();
                    if (input.equals("0"))
                        break;
                    authors.add(input);
                }
                magazine.setAuthorList(authors);
                System.out.println("Enter the Publisher of the Magazine: ");
                input=scanner2.nextLine();
                magazine.setPublisher(input);
                System.out.println("Enter the Popularity Count of Magazine: ");
                int input2=scanner2.nextInt();
                magazine.setPopularityCount(input2);
                System.out.println("Enter the Cost of Magazine: ");
                input2=scanner2.nextInt();
                magazine.setCost(input2);
                itemList.add(magazine);
                System.out.println("Item Added!!!!");
            }
            if(choice2.equals("3"))
            {
                Newspaper newspaper=new Newspaper();
                newspaper.setBorrowed(false);
                newspaper.setId(Item.getNextId());
                newspaper.incrementNextId();
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Enter Tittle of Newspaper: ");
                String input = scanner.nextLine();
                newspaper.setTittle(input);
                System.out.println("Enter the Publisher of Newspaper: ");
                input = scanner.nextLine();
                newspaper.setPublisher(input);
                System.out.println("Enter the Popularity Count of Newspaper: ");
                int input2=scanner2.nextInt();
                newspaper.setPopularityCount(input2);
                System.out.println("Enter the Date of the Newspaper(dd-MM-yyyy): ");
                String userInput = scanner.nextLine();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);
                try {
                    Date date = dateFormat.parse(userInput);
                    newspaper.setDate(date);
                    System.out.println("Date entered: " + dateFormat.format(date));
                    itemList.add(newspaper);
                    System.out.println("Item Added!!!!");
                } catch (ParseException e) {
                    System.err.println("Invalid date format. Please enter a date in dd-mm-yyyy format.");
                }
            }
            if(choice2.equals("0"))
            {
             break;
            }

        }

    }
    public void deleteItem(int id)
    {
        Object o=getItemById(id);
        if(Objects.isNull(o))
        {
            System.out.println("Item does not Exists");
        }
        else {
            itemList.remove(o);
            System.out.println("Item deleted");
        }
    }
}
