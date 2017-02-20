/**
 * Created by polkymour on 12/12/2016.
 */


import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class ControllerTest {

    Controller controller = new Controller();
    Contact myContact = new Contact("", "");

    @Test
    public void printPhoneBookAllFormatsShouldPrintInPlainAndJsonFormats() {

        OutputPrinter outputPrinter = Mockito.mock(OutputPrinter.class);
        controller.outputPrinter = outputPrinter;

        controller.printPhoneBookAllFormats();

        verify(outputPrinter, times(1)).printPhoneBook(ArgumentMatchers.<Contact>anyList());
        verify(outputPrinter, times(1)).printPhoneBookAsJsonString(ArgumentMatchers.<Contact>anyList());

    }



    @Test
    public void caut() throws IOException, DonaldTrumpException {

        InputReader inputReader = Mockito.mock(InputReader.class);
        controller.inputReader = inputReader;

        when(inputReader.readAContact()).thenReturn(myContact);

        controller.runController();


        Assert.assertEquals(inputReader.readAContact(),myContact);

    }


}