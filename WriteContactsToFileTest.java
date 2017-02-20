import org.junit.Assert;
import org.junit.Test;
import java.io.FileOutputStream;
import java.io.FileInputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.mockito.Mockito.*;


/**
 * Created by polkymour on 30/11/2016.
 */
public class WriteContactsToFileTest {

    private String phoneBookPath = ("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\TestPhoneBook.csv");
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";


    @Test

    public void canWriteContactsToFile() throws IOException {


        WriteContactsToFile writeContactsToFile = new WriteContactsToFile();
        List<Contact> phoneBook = new ArrayList();
        FileWriter fileWriter = new FileWriter(phoneBookPath);
        File phoneBookTestFile = new File(phoneBookPath);


        Contact contact1 = new Contact("Bob", "789787");
        Contact contact2 = new Contact("jane", "45544");

        phoneBook.add(contact1);
        phoneBook.add(contact2);


        for (Contact myContact : phoneBook) {

            fileWriter.append(myContact.getName());
            fileWriter.append(COMMA_DELIMITER);
            fileWriter.append(myContact.getPhoneNumber());
            fileWriter.append(NEW_LINE_SEPARATOR);


        }

            writeContactsToFile.setPhoneBookPath(phoneBookPath);

            fileWriter.close();
            String string = readFileToString(phoneBookTestFile);



            Assert.assertEquals("Bob,789787\n" +
                    "jane,45544\n" , string);


        phoneBookTestFile.deleteOnExit();


        }
    }
