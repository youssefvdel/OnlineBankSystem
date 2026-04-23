package manager;



import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class AdminActionLogger {
    private static final String FILE = "data/reports.ser";
    private static ArrayList<String> logs = new ArrayList<>();
    
    public static void log(String adminName, String action) {
        logs.add("[" + new Date() + "] " + adminName + ": " + action);
        save();
    }
    
    private static void save() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE))) {
            out.writeObject(logs);
        } catch (IOException e) {}
    }
    
    public static ArrayList<String> getLogs() {
        return logs;
    }
}