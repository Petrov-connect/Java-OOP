package loggerLib.appenders;
//created by J.M.

import loggerLib.coustomFiles.LogFile;
import loggerLib.coustomFiles.interfaces.File;
import loggerLib.enumerations.ReportLevel;
import loggerLib.layouts.interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;
    public FileAppender(Layout layout) {
        super(layout);

    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file){
        this.file = file;
    }

    @Override
    public void append(String data, ReportLevel reportLevel, String message) {
        if (this.file == null){
            try {
                this.setFile(new LogFile());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String str = this.format(data,reportLevel,message);

        file.appendBuffer(str);
        this.file.write();

    }

    @Override
    public String toString() {
        return super.toString() + ", File size: "+ this.file.getSize();
    }
}
