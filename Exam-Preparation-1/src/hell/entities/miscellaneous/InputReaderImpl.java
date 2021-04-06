package hell.entities.miscellaneous;
//created by J.M.

import hell.interfaces.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReaderImpl implements InputReader {

    private final BufferedReader reader;

    public InputReaderImpl() {

        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String readLine() {
        try {
            return this.reader.readLine();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
