package cresla;
//created by J.M.

import cresla.manager.InputReaderImpl;
import cresla.manager.ManagerImpl;
import cresla.manager.OutputWriterImpl;

public class Main {

    public static void main(String[] args) {

        ManagerImpl manager = new ManagerImpl(new InputReaderImpl(), new OutputWriterImpl());
        manager.run();
    }
}
