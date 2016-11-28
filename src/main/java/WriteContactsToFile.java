/**
 * Created by polkymour on 15/11/2016.
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class WriteContactsToFile {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Name,phone number";


    void writeContactsToFile(List<Contact> phoneBook) throws java.io.IOException {


        FileWriter fileWriter = null;


        File PhoneBook = new File("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv");
        if (!PhoneBook.exists()) {

                fileWriter = new FileWriter("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv");

                fileWriter.append(FILE_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                System.out.println("CSV file was created successfully");
        }

        else {

            fileWriter = new FileWriter("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv", true);
        }
        try {

                for (Contact myContact : phoneBook) {
                    fileWriter.append(myContact.getName());
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(myContact.getPhoneNumber());
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }

                System.out.println("CSV file was added to successfully");

            } catch (Exception e) {
                System.out.println("Error in CsvFileWriter");
                e.printStackTrace();
            } finally {

                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter");
                    e.printStackTrace();
              }
        }
    }
}
