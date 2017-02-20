import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Scanner;

import static org.mockito.Mockito.when;

/**
 * Created by polkymour on 13/12/2016.
 */
public class InputReaderTest {

    InputReader inputReader = new InputReader();


    @Test
    public void logsErrorMessages() throws IOException, DonaldTrumpException {

        Logger  = Mockito.mock(Scanner.class);

        inputReader.userInput = userInput;

        Contact myContact = new Contact("bob", "ddd" );

        when(inputReader.readAContact()).thenReturn(myContact);

        Assert.assertEquals("bob", "ddd", myContact);


    }
}

/*
 public void printPhoneBookAllFormatsShouldPrintInPlainAndJsonFormats() {

        OutputPrinter outputPrinter = Mockito.mock(OutputPrinter.class);
        controller.outputPrinter = outputPrinter;

        controller.printPhoneBookAllFormats();

        verify(outputPrinter, times(1)).printPhoneBook(ArgumentMatchers.<Contact>anyList());
        verify(outputPrinter, times(1)).printPhoneBookAsJsonString(ArgumentMatchers.<Contact>anyList());

    }

 */
