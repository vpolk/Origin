/**
 * Created by polkymour on 2/11/2016.
 *
 * @Test

public void canPrintPhoneBook() {
OutputPrinter outputPrinter = new OutputPrinter();
List<Contact> phoneBook = new ArrayList();

Contact contact1 = new Contact("Bobbob", "789787");
Contact contact2 = new Contact("jane", "45544");

phoneBook.add(contact1);
phoneBook.add(contact2);

outputPrinter.printPhoneBook(phoneBook);

assertEquals("" , phoneBook);




}
 *
 */

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OutputPrinterTest {

    @Test

    public void canPrintPhoneBookAsJsonString() {

        OutputPrinter outputPrinter = new OutputPrinter();
        List<Contact> phoneBook = new ArrayList();

        Contact contact1 = new Contact("Bob", "789787");
        Contact contact2 = new Contact("jane", "45544");

        phoneBook.add(contact1);
        phoneBook.add(contact2);

        String myContacts = outputPrinter.printPhoneBookAsJsonString(phoneBook);


        Assert.assertEquals("[{\"name\":\"Bob\",\"phoneNumber\":\"789787\"},{\"name\":\"jane\",\"phoneNumber\":\"45544\"}]", myContacts);
    }
}


/**
import org.junit.Test;
        import static org.junit.Assert.assertEquals;

public class TestJunit {

    String message = "Hello World";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        assertEquals(message,messageUtil.printMessage());
    }
}

 */