package utils;

import java.io.*;
import java.util.*;
import exceptions.DataLoadException;

/**
 * Utility class for reading and writing CSV files.
 * Handles parsing, escaping, and type conversion for CSV data.
 * 
 * @author Youssef Adel 258270
 * @version Phase 2
 */
public class CSVHelper {
    
    private static final String DELIMITER = ",";
    private static final String ESCAPE_CHAR = "\"";
    
    /**
     * Reads all non-empty lines from a CSV file.
     * Returns an empty list if the file does not exist (not an error).
     * 
     * @param filePath the path to the CSV file
     * @return a list of lines from the file
     * @throws DataLoadException if an I/O error occurs while reading
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
            return lines;
        } catch (IOException e) {
            throw new DataLoadException(filePath, "read", e);
        }
        return lines;
    }
    
    /**
     * Writes a list of lines to a CSV file.
     * 
     * @param filePath the path to the output file
     * @param lines the lines to write
     * @throws DataLoadException if an I/O error occurs while writing
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
     * Parses a CSV line into individual fields, handling quoted values.
     * 
     * @param line the CSV line to parse
     * @return a list of field values with whitespace trimmed
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
     * Escapes a value for CSV output if it contains special characters.
     * 
     * @param value the string to escape
     * @return the escaped string, or empty string if null
     */
    public static String escape(String value) {
        if (value == null) return "";
        if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            return ESCAPE_CHAR + value.replace("\"", "\"\"") + ESCAPE_CHAR;
        }
        return value;
    }
    
    /**
     * Joins multiple values into a single CSV line.
     * 
     * @param values the values to join
     * @return a CSV-formatted string
     */
    public static String join(String... values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) sb.append(DELIMITER);
            sb.append(escape(values[i]));
        }
        return sb.toString();
    }
    
    /**
     * Parses a string as an integer, returning a default value on failure.
     * 
     * @param s the string to parse
     * @param defaultValue the value to return if parsing fails
     * @return the parsed integer or the default value
     */
    public static int parseInt(String s, int defaultValue) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
    
    /**
     * Parses a string as a double, returning a default value on failure.
     * 
     * @param s the string to parse
     * @param defaultValue the value to return if parsing fails
     * @return the parsed double or the default value
     */
    public static double parseDouble(String s, double defaultValue) {
        try {
            return Double.parseDouble(s.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
