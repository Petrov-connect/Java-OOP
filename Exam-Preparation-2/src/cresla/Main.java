package cresla;
//created by J.M.

import cresla.core.InputReaderImpl;
import cresla.core.ManagerImpl;
import cresla.core.OutputWriterImpl;
import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();
        Manager manager = new ManagerImpl();

        while (true) {

            String[] command = reader.readLine().split("\\s+");

            List<String> arguments = Arrays.stream(command).skip(1).collect(Collectors.toList());

            switch (command[0]) {

                case "Reactor":
                    writer.write(manager.reactorCommand(arguments));
                    break;
                case "Module":
                    writer.write(manager.moduleCommand(arguments));
                    break;
                case "Report":
                    writer.write(manager.reportCommand(arguments));
                    break;
                case "Exit":
                    writer.write(manager.exitCommand(arguments));
                    return;
            }
        }
    }
}

