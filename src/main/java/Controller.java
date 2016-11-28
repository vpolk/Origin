
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by polkymour on 25/10/2016.
 *
 * next exercise is to move the code that reads from keyboard and creates the Contact object into it's own class (and therefore into its own method)
 the idea is to structure the code so that each class is responsible for just one task
 we'll have one input reader,
 one output printer
 and one controller that coordinates the other classes
 ok
 Dan Polk (polkosity@gmail.com)
 so write a method (readAContact) in a class (InputReader) that reads from keyboard and returns a Contact object
 if the user enters a blank, you can return null
 then in the controller class (the one with main method) keep calling readAContact and adding the Contacts to the List until the return value is null
 *
 *
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
 */


public class Controller {

    final static Logger logger = Logger.getLogger(Controller.class);
    public static List<Contact> phoneBook = new ArrayList();
    public static InputReader inputReader = new InputReader();
    public static OutputPrinter outputPrinter = new OutputPrinter();
    public static WriteContactsToFile writeContactsToFile = new WriteContactsToFile();
    public static ReadContactsFromFile readContactsFromFile = new ReadContactsFromFile();

    public static void main(String[] args) throws IOException {

        while (true) {
            try {
                Contact myContact = inputReader.readAContact();

                if (myContact == null) {
                    System.out.println("Contacts entered");
                    break;
                } else {
                    phoneBook.add(myContact);
                }
            } catch (DonaldTrumpException e) {
                logger.error("Caught DonaldTrumpException: ", e);
            }
        }
        outputPrinter.printPhoneBook(phoneBook);
        outputPrinter.printPhoneBookAsJsonString(phoneBook);
        writeContactsToFile.writeContactsToFile(phoneBook);
        readContactsFromFile.readContactsFromFile();

    }
 }
