
package librarysystem;

import java.io.*;
import java.util.*;

public class FileHandling {

    private static String folderDirectory = System.getProperty("user.dir") + "\\booklist.txt";

    public static void writeFile(ArrayList<books> book1) {

        try {
            FileWriter writeToFile = new FileWriter(folderDirectory, false);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for (int i = 0; i < book1.size(); i++) {
                printToFile.println(book1.get(i).toString());
            }
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<books> readFile() {
        ArrayList<books> book1 = new ArrayList<>();
        String lineFromFile;
        try {
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while ((lineFromFile = read.readLine()) != null) {
                String[] bookDetails = lineFromFile.split(", ");
                books myBook = new books(bookDetails[0], bookDetails[1], bookDetails[2], Double.parseDouble(bookDetails[3]), bookDetails[4]);
                book1.add(myBook);

            }
            read.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return book1;
    }
}
