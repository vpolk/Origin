
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

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

    final Logger logger = Logger.getLogger(Controller.class);
    public List<Contact> phoneBook = new ArrayList();
    public InputReader inputReader = new InputReader();
    public OutputPrinter outputPrinter = new OutputPrinter();
    public WriteContactsToFile writeContactsToFile = new WriteContactsToFile();
    public FileContentsReader fileContentsReader = new FileContentsReader();



    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();
        controller.runController();
    }

    protected void runController() throws IOException {
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
        printPhoneBookAllFormats();
        setFilePathAndWriteContactsToFile();

        fileContentsReader.setPhoneBookPath("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv");
        fileContentsReader.readContactsFromFile();
        System.out.println(fileContentsReader.readContactsFromFile());
            }

    protected void printPhoneBookAllFormats() {
        outputPrinter.printPhoneBook(phoneBook);
        outputPrinter.printPhoneBookAsJsonString(phoneBook);
    }
    protected void setFilePathAndWriteContactsToFile() throws IOException{
        writeContactsToFile.setPhoneBookPath("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv");
        writeContactsToFile.writeContactsToFile(phoneBook);

    }
 }
