package loggerLib;
//created by J.M.

import loggerLib.appenders.ConsoleAppender;
import loggerLib.appenders.FileAppender;
import loggerLib.appenders.interfaces.Appender;
import loggerLib.enumerations.ReportLevel;
import loggerLib.layouts.SimpleLayout;
import loggerLib.layouts.XmlLayout;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.loggers.MessageLogger;
import loggerLib.loggers.interfaces.Logger;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {

        //Functionality.connectToServer("","");

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Appender[] appenders = new Appender[n];
        int index = 0;

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            Appender appender;
            Layout layout;

            if (input[1].equals("SimpleLayout")) {
                layout = new SimpleLayout();
            } else {
                layout = new XmlLayout();
            }

            if (input[0].equals("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else {
                appender = new FileAppender(layout);
            }
            if (input.length == 3) {
                appender.setReportLevel(ReportLevel.valueOf(input[2]));
            }
            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String line = scanner.nextLine();

        while (!line.equals("END")) {
            String[] input = line.split("\\|");

            switch (ReportLevel.valueOf(input[0])) {
                case INFO:
                    logger.logInfo(input[1], input[2]);
                    break;
                case ERROR:
                    logger.logError(input[1], input[2]);

                    break;
                case FATAL:
                    logger.logFatal(input[1], input[2]);

                    break;
                case WARNING:
                    logger.logWarning(input[1], input[2]);

                    break;
                case CRITICAL:
                    logger.logCritical(input[1], input[2]);

                    break;
            }

            line = scanner.nextLine();

        }

        System.out.println(logger.toString());
    }
}
