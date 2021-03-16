package loggerLib.appenders.interfaces;
//created by J.M.

import loggerLib.enumerations.ReportLevel;

public interface Appender {
    void append(String data, ReportLevel reportLevel, String message);
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
