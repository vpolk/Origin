import java.io.*;

import static org.apache.commons.io.FileUtils.readFileToString;


/**
 * Created by polkymour on 15/11/2016.
 */
public class FileContentsReader {


    private String phoneBookPath = ("C:\\Users\\polkymour\\IdeaProjects\\PhoneBookRemodelled\\PhoneBook.csv");



    public void setPhoneBookPath(String phoneBookPath) {
        this.phoneBookPath = phoneBookPath;
    }

    public String readContactsFromFile() throws IOException {
        File PhoneBookFile = new File(phoneBookPath);
        String fileContents = readFileToString(PhoneBookFile);
        return fileContents;


    }


}

