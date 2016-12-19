/**
 * Created by polkymour on 15/11/2016.
 *
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class WriteContactsToFile {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private String phoneBookPath;

    public void setPhoneBookPath(String phoneBookPath) {
        this.phoneBookPath = phoneBookPath;
    }

    //CSV file header
    private static final String FILE_HEADER = "Name,phone number";


    public FileWriter writeContactsToFile(List<Contact> phoneBook) throws java.io.IOException {


        FileWriter fileWriter = null;

        File PhoneBook = new File(phoneBookPath);

        if (!PhoneBook.exists()) {

                fileWriter = new FileWriter(phoneBookPath);

                fileWriter.append(FILE_HEADER);
                fileWriter.append(NEW_LINE_SEPARATOR);
                System.out.println("CSV file was created successfully");
        }

        else {

            fileWriter = new FileWriter(phoneBookPath, true);
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
                    System.out.println("file writer closed");

                } catch (IOException e) {
                    System.out.println("Error while flushing/closing fileWriter");
                    e.printStackTrace();
              }
        }
                return fileWriter;
    }
}
