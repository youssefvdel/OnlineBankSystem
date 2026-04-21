package utils;

import java.io.*;
import java.util.*;
import exceptions.DataLoadException;

/**
 * CSV file helper - read/write and parse methods.
 * @author Youssef Adel - 258270
 */
public class CSVHelper {
    
    private static final String DELIMITER = ",";
    private static final String ESCAPE_CHAR = "\"";
    
    /**
     * Read file lines, skip empty ones.
     * Returns empty list if file not found (not an error).
     */
    public static List<String> readLines(String filePath) throws DataLoadException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    lines.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            // file not found is ok, return empty list
            return lines;
        } catch (IOException e) {
            throw new DataLoadException(filePath, "read", e);
        }
        return lines;
    }
    
    /**
     * Write lines to file, overwrites existing.
     */
    public static void writeLines(String filePath, List<String> lines) throws DataLoadException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            for (String line : lines) {
                pw.println(line);
            }
        } catch (IOException e) {
            throw new DataLoadException(filePath, "write", e);
        }
    }
    
    /**
     * Split CSV line into fields, handles quotes.
     */
    public static List<String> parseLine(String line) {
        List<String> fields = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                fields.add(current.toString().trim());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        fields.add(current.toString().trim());
        return fields;
    }
    
    /**
     * Escape value for CSV - wrap if has comma or quote.
     */
    public static String escape(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return ESCAPE_CHAR + value.replace("\"", "\"\"") + ESCAPE_CHAR;
        }
        return value;
    }
    
    /**
     * Join values with comma.
     */
    public static String join(String... values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) sb.append(DELIMITER);
            sb.append(escape(values[i]));
        }
        return sb.toString();
    }
    
    // Helper parsers - return default if parse fails
    public static int parseInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    public static double parseDouble(String s, double defaultValue) {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
