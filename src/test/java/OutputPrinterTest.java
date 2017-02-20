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
 */


import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OutputPrinterTest {

    @Test

    public void canPrintPhoneBookAsJsonString() {

        OutputPrinter outputPrinter = new OutputPrinter();
        HashMap<String, Contact> phoneBook = new HashMap();


        Contact contact1 = new Contact("Bob", "789787", "8 bla st","male");
        Contact contact2 = new Contact("jane", "45544", "7 bee st", "female");

        phoneBook.put("Bob", contact1);
        phoneBook.put("jane", contact2);

        String myContacts = outputPrinter.printPhoneBookAsJsonString(phoneBook);


        Assert.assertEquals("{\"Bob\":{\"name\":\"Bob\",\"phoneNumber\":\"789787\",\"gender\":\"male\",\"address\":\"8 bla st\"},\"jane\":{\"name\":\"jane\",\"phoneNumber\":\"45544\",\"gender\":\"female\",\"address\":\"7 bee st\"}}", myContacts);
    }
}

