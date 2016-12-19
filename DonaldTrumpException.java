import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by polkymour on 8/11/2016.
 *
 public class MyException extends Exception { public MyException(String message) { super(message); } }
 but with the correct name
 then when printing, before printing, do a check to make sure the name is ok, if not, throw the exception....
 the tutorial you have done should show you how to throw an exception
 "throw new DonaldTrumpException("some message here")"

 and print out the messgae (all exceptions have a message and a stack trace... a stack trace is the list of nested calls that are active, i.e. each call from the main method thorugh to where the exception was thrown... sometimes in a big program, the stack trace can take up pages)
 then you can use a logging framework (start with log4j) to write your caught exception's messages to a  log
 you can log some events at different levels, then run the app with logging configured at different levels and observe that the log lines set at a lower severity than the logger is running at will not be added to the log

 */


public class DonaldTrumpException extends Exception {
    public DonaldTrumpException (String message) {
        super (message);

    }


}

