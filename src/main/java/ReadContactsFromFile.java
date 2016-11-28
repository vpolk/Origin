import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by polkymour on 15/11/2016.
 */
public class ReadContactsFromFile {


    final static Logger logger = Logger.getLogger(ReadContactsFromFile.class);

    public static void readContactsFromFile() {

        BufferedReader br = null;

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
                logger.debug(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
