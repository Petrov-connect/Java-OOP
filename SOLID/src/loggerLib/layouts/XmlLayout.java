package loggerLib.layouts;
//created by J.M.

import loggerLib.enumerations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;

public class XmlLayout implements Layout {
    @Override
    public String format(String date, ReportLevel reportLevel, String message) {
        return String.format( "<log>\r\n" +
                "   <date>%s</date>\n" +
                "   <level>%s</level>\r\n" +
                "   <message>%s</message>\n" +
                "</log>\r\n",date,reportLevel.toString(),message);
    }
}
