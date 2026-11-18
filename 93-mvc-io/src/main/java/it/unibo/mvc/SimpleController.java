package it.unibo.mvc;

import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private List<String> stringHistory = new ArrayList<>();
    private String currentString;

    @Override
    public void setNextStringToPrint(String content) {
        if (content == null) {
            throw new NullPointerException("La stringa non può essere null");
        } else {
            this.currentString = content;    
        }
    }

    @Override
    public String getNextStringToPrint() {
        return this.currentString;
    }

    @Override
    public List<String> getStringsHistory() {
        return List.copyOf(this.stringHistory);
    }

    @Override
    public void printCurrentString() {
        if (currentString == null) {
            throw new IllegalStateException("La stringa non può essere null");
        } else {
            stringHistory.add(this.currentString); //aggiungiamo la stringa cur alla lista della storia
            IO.println(this.currentString);
        }

    }
}
