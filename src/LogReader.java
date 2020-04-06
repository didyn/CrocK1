import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class LogReader {

    private BufferedReader r;
    private Log currentLog;
    private int[] currentArray;
    private int difference;

    public LogReader(String fileName) throws IOException {
        r = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(fileName))));
        nextCurrentLog();
        this.difference = currentLog.getTimeStart();
        arrayMethod();

    }

    public Log getCurrentLog() {
        return currentLog;
    }

    public int[] getCurrentArray() {
        return currentArray;
    }

    private void nextCurrentLog() throws IOException {
        String line = r.readLine();
        currentLog = line == null
                ? null: Log.parse(line);
    }

    private void arrayMethod(){
        currentArray = new int[currentLog.getTimeEnd() - currentLog.getTimeStart() + 1];
        for (int i = currentLog.getTimeStart() - difference; i <= currentLog.getTimeEnd() - difference;i++)
            currentArray[i]++;


    }

    public void nextArray() throws IOException {
        nextCurrentLog();
        if (currentLog != null) {
            if (currentLog.getTimeEnd() > currentArray.length) {
                currentArray = Arrays.copyOf(currentArray, currentLog.getTimeEnd() - difference + 1);
            }
            for (int i = currentLog.getTimeStart() - difference; i <= currentLog.getTimeEnd() - difference; i++) {
                currentArray[i]++;
            }
        }


    }

}
