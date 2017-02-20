import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by polkymour on 25/10/2016.
 */
public class InputReader   {

    Scanner userInput = new Scanner(System.in);
    static Logger logger = Logger.getLogger(Controller.class);



    public Contact readAContact () throws DonaldTrumpException {

        String name;
        System.out.print("Enter contact name:");
        name = userInput.nextLine();
        logger.debug("Contact is " + name);

       if (name.equals("Donald Trump")) {
           throw new DonaldTrumpException( "Refusing to add Donald Trump as a contact!");
       }


        else if (name.equals("")) {
            return null;

        } else {

           String phoneNumber;
           System.out.print("Enter phone number:");
           phoneNumber = userInput.nextLine();
           logger.debug("Ph.Number is " + phoneNumber);
           String address;
           System.out.print("Enter address:");
           address = userInput.nextLine();
           String gender;
           System.out.print("Enter gender:");
           gender = userInput.nextLine();


            if (phoneNumber.equals("")) {
                return null;

            } else {

                Contact myContact = new Contact(name, phoneNumber, address, gender);
                return (myContact);
            }
        }
    }
}














