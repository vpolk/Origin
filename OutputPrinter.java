import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.util.List;


/**
 * Created by polkymour on 25/10/2016.
 *
 *
 later, we will make intellij use a latest version of Java
 ok, that works
 12:09 PM
 Dan Polk (polkosity@gmail.com)
 OK, so you should write a loop in OutputPrinter that prints the contacts like this:
 Name: Bob
 Number: 123
 ---
 Name: Alice
 Number 456
 pass the method the whole List, and it should nicely print each Contact's data
 then you can work on converting the Contact into JSON


 /*   public String printPhoneBookAsJsonString(List<Contact> phoneBook) {
 String myPhoneBook = new String();
 try {
 myPhoneBook = mapper.writeValueAsString(phoneBook);

 } catch (JsonProcessingException j) {
 System.err.println("Caught JasonProcessingEception: " + j.getMessage());

 }
 return myPhoneBook;
 }
 }






 */
public class OutputPrinter {

    ObjectMapper mapper = new ObjectMapper();
    final static Logger logger = Logger.getLogger(Controller.class);

    void printPhoneBook(List<Contact> phoneBook) {

        for (Contact myContact : phoneBook) {
            System.out.println("");
            System.out.println("Name:" + " " + (myContact.getName()));
            System.out.println("Number:" + " " + (myContact.getPhoneNumber()));
            System.out.println("_ _ _");

        }
    }

    public String printPhoneBookAsJsonString(List<Contact> phoneBook){

        ObjectMapper mapper = new ObjectMapper();
        String myPhoneBook = new String();

        try {
            myPhoneBook = mapper.writeValueAsString(phoneBook);
            System.out.println(myPhoneBook);


        } catch (JsonProcessingException e) {
             logger.error("error processing json : " + e);
        }

        return myPhoneBook;
    }

   
}

