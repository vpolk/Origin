import org.junit.Test;
import org.junit.Assert;
import org.mockito.Mockito;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.apache.commons.io.FileUtils.readFileToString;


/**
 * Created by polkymour on 7/12/2016.
 */
public class FileContentsReaderTest {

    private String phoneBookPath = ("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\TestPhoneBook.csv");
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    @Test

    public void canReadContactsFromFile() throws IOException {

        FileContentsReader fileContentsReader = new FileContentsReader();
        List<Contact> phoneBook = new ArrayList();
        FileWriter fileWriter = new FileWriter(phoneBookPath);
        File phoneBookFile = new File(phoneBookPath);


        Contact contact1 = new Contact("Bob", "789787", "8 bla st","male");
        Contact contact2 = new Contact("jane", "45544", "7 bee st", "female");

        phoneBook.add(contact1);
        phoneBook.add(contact2);

        for (Contact myContact : phoneBook) {
            fileWriter.append(myContact.getName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(myContact.getPhoneNumber());
            fileWriter.append(NEW_LINE_SEPARATOR);
        }

        fileWriter.close();

        fileContentsReader.setPhoneBookPath(phoneBookPath);
        String fileContents = fileContentsReader.readContactsFromFile();

        assertEquals("Bob,789787\n" +
                "jane,45544\n", fileContents);

        System.out.println(fileContents);
        phoneBookFile.deleteOnExit();
    }
}