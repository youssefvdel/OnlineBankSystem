package manager;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Logs admin actions to a text file.
 * @author Yousef Mohiey - 248679
 */
public class AdminActionLogger {
    
    private static final String LOG_FILE = "data/admin_logs.t";

    /**
     * Appends an action with timestamp to the log file.
     */
    public static void log(String action) {
        String entry = LocalDateTime.now() + " | " + action;
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            writer.write(entry);
            writer.newLine();
        } catch (IOException e) {
        }
    }
}