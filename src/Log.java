public class Log {

    private int timeStart;
    private int timeEnd;

    public Log(int timeStart, int timeEnd) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public int getTimeEnd() {
        return timeEnd;
    }

    public int getTimeStart() {
        return timeStart;
    }


    static Log parse(String string){
        if (string == null)
            return null;
        String[] tokens = string.split(",", 2);
        return new Log(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));

    }
}
