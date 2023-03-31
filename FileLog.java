import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class FileLog {
    static int lineCounter;
    static int fileCounter;

    static synchronized void Write(File file, String login, String stackContent, String result) throws IOException {
        if (lineCounter >= 10) {
            FileLog.fileCounter = Calc.logDir.listFiles().length;
            Calc.logArch = new File(file.getPath() + "." + fileCounter);
            lineCounter = 0;
        }
        Calendar calendar = Calendar.getInstance();
        try (BufferedWriter br = new BufferedWriter(new FileWriter((file), true))) {
            br.write(calendar.getTime().toString() + "; " + stackContent + result + "; " + login + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedWriter br = new BufferedWriter(new FileWriter((Calc.logArch), true))) {
            br.write(calendar.getTime().toString() + "; " + stackContent + result + "; " + login + "\n");
            lineCounter++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
