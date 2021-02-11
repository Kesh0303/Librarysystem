package librarysystem;

import java.util.Scanner;
import java.util.ArrayList;

public class Librarysystem {

    private static Scanner input = new Scanner(System.in);
    private static ArrayList<books> booklist = new ArrayList<>();
    private static ArrayList<bookBorrowing> borrowers = new ArrayList<>();

    public static void main(String[] args) {
        booklist = FileHandling.readFile();
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to the library system");
        while (true) {

            System.out.println("What would you like to do?");
            System.out.println("1 - Add a new book");
            System.out.println("2 - View all books");
            System.out.println("3 - Edit a book");
            System.out.println("4 - Delete a book");
            System.out.println("5 - Add a new borrower");
            System.out.println("6 - Edit borrower's list");
            System.out.println("7 - Delete a borrower");

            System.out.println("0 - Exit");
            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:

                    addbook();
                    break;

                case 2:

                    viewBooks();
                    break;

                case 3:
                    editBook();
                    break;

                case 4:
                    deleteBook();
                    break;

                case 5:
                    addborrower();
                    break;

                case 6:
                    editBorrower();
                    break;

                case 7:
                    deleteBorrower();

                case 8:
                    viewBorrowerList();

                case 0:
                    FileHandling.writeFile(booklist);
                    System.exit(0);

            }
        }

    }

    public static void addbook() {
        //(String name, String ISBN, String author, double price, String genre 
        System.out.println("Please type in a name");
        input.nextLine();//to stop it from skipping line (always check because it doesnt always need it)
        String name = input.nextLine();
        System.out.println("Please type in an ISBN");
        String ISBN = input.next();
        System.out.println("Please type in an author");
        String author = input.nextLine();
        input.nextLine();
        System.out.println("Please type in a price");
        double price = input.nextDouble();
        System.out.println("Please type in a genre");
        input.nextLine();
        String genre = input.nextLine();

        books myBook = new books(name, ISBN, author, price, genre);
        booklist.add(myBook);

        System.out.println(myBook.toString());
    }

    public static void viewBooks() {
        if (booklist.isEmpty()) {
            System.out.println("Sorry, there are no books right now");
        } else {
            for (int i = 0; i < booklist.size(); i++) {
                System.out.println(booklist.get(i).toString());
            }
        }
    }

    public static void editBook() {

        int index = getBookIndex();

        if (index != -1) {
            System.out.println("which bit would you like to edit?");
            System.out.println("1 - name");
            System.out.println("2 - ISBN");
            System.out.println("3 - author");
            System.out.println("4 - price");
            System.out.println("5 - genre");
            int userChoice = input.nextInt();
            switch (userChoice) {
                case 1:
                    System.out.println("please type in the name");
                    String newName = input.nextLine();
                    input.nextLine();
                    booklist.get(index).setName(newName);

                    break;

                case 2:
                    System.out.println("please type in the ISBN");
                    String newISBN = input.next();
                    booklist.get(index).setISBN(newISBN);
                    break;

                case 3:
                    System.out.println("please type in the author");
                    String newAuthor = input.nextLine();
                    booklist.get(index).setAuthor(newAuthor);

                    break;

                case 4:
                    System.out.println("please type in the price");
                    double newPrice = input.nextDouble();
                    booklist.get(index).setPrice(newPrice);

                    break;

                case 5:
                    System.out.println("please type in the genre");
                    input.nextLine();
                    String newGenre = input.nextLine();
                    booklist.get(index).setGenre(newGenre);

                    break;

            }
            System.out.println("book has been successfully changed to " + booklist.get(index).toString());
        } else {
            System.out.println("Cannot find the book");
        }

    }

    public static void deleteBook() {
        int index = getBookIndex();

        if (index != -1) {
            booklist.remove(index);
            System.out.println("Successfully removed");
        } else {
            System.out.println("Sorry, I can't find that book");
        }
    }

    public static int getBookIndex() {

        if (booklist.isEmpty()) {
            return -1;
        } else {
            System.out.println("please type in the ISBN");
            String isbn = input.next();
            for (int i = 0; i < booklist.size(); i++) {
                if (isbn.equals(booklist.get(i).getISBN())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void addborrower() {
        System.out.println("Please type in a name");
        input.nextLine();
        String name = input.nextLine();
        System.out.println("Please type in the date");
        int date = input.nextInt();
        System.out.println("Please type in the month");
        int month = input.nextInt();
        System.out.println("Please type in the year");
        int year = input.nextInt();

        bookBorrowing Myborrowers = new bookBorrowing(name, date, month, year);
        borrowers.add(Myborrowers);
        System.out.println(Myborrowers.toString());
    }

    public static void editBorrower() {
        int index = getBorrowerInfo();
        if (index != -1) {
            System.out.println("What would you like to change?");
            System.out.println("1 -name");
            System.out.println("2 - date of birth");
            System.out.println("3 - month of birth");
            System.out.println("4 - year of birth");

            int userChoice = input.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Please type in a name");
                    String newName = input.nextLine();
                    borrowers.get(index).setName(newName);

                    break;

                case 2:
                    System.out.println("Please type in a date");
                    int newDate = input.nextInt();
                    borrowers.get(index).setDate(newDate);

                    break;

                case 3:
                    System.out.println("Please type in a month");
                    int newMonth = input.nextInt();
                    borrowers.get(index).setMonth(newMonth);

                    break;

                case 4:
                    System.out.println("Please type in a year");
                    int newYear = input.nextInt();
                    borrowers.get(index).setYear(newYear);

                    break;

            }
            System.out.println("Your borrower information has been changed to " + borrowers.get(index).toString());
        } else {
            System.out.println("Cannot find the specified borrower");

        }

    }

    public static void deleteBorrower() {
        int index = getBorrowerInfo();
        if (index != -1) {
            borrowers.remove(index);
            System.out.println("Successfully removed");
        } else {
            System.out.println("Cannot find the borrower");

        }
    }

    public static int getBorrowerInfo() {
        if (borrowers.isEmpty()) {
            return -1;

        } else {
            System.out.println("Please type in a name");
            String name = input.nextLine();
            for (int i = 0; i < borrowers.size(); i++) {
                if (name.equals(borrowers.get(i).getName())) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void viewBorrowerList() {
        if (borrowers.isEmpty()) {
            System.out.println("Sorry, there are no borrowers right now");
        } else {
            for (int i = 0; i < borrowers.size(); i++) {
                System.out.println(borrowers.get(i).toString());
            }
        }
    }

}
