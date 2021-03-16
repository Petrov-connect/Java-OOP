package loggerLib;
//created by J.M.

import loggerLib.appenders.SocketAppender;
import loggerLib.appenders.interfaces.Appender;
import loggerLib.layouts.XmlLayout;
import loggerLib.layouts.interfaces.Layout;
import loggerLib.loggers.MessageLogger;
import loggerLib.loggers.interfaces.Logger;

import java.io.IOException;

public abstract class Functionality {

    public static void connectToServer(String dade,String message) throws IOException {
        Layout layout = new XmlLayout();
        Appender appender = new SocketAppender(layout);
        Logger logger = new MessageLogger(appender);
        logger.logInfo("16.03.20021","Hello Gogo");
    }
}
