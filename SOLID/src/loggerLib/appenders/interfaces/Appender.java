package loggerLib.appenders.interfaces;
//created by J.M.

import loggerLib.enumerations.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String data, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
