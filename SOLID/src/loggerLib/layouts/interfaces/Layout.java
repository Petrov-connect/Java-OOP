package loggerLib.layouts.interfaces;
//created by J.M.

import loggerLib.enumerations.ReportLevel;

public interface Layout {
    String format(String data, ReportLevel reportLevel, String message);
}
