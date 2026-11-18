package it.unibo.mvc;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * This interface represents a controller in the MVC pattern,
 * responsible for managing the flow of data between the model and the view.
 */
public interface Controller {

    void setNextStringToPrint(String content);

    String getNextStringToPrint();

    List<String> getStringsHistory();

    void printCurrentString();
    
}
