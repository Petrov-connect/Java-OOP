package manager;
//created by J.M.

import interfaces.OutputWriter;

public class OutputManager implements OutputWriter {

    @Override
    public void write(String output) {
        System.out.println(output);
    }
}
