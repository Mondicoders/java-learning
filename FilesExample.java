import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

public class FilesExample {
    public static void main(String[] args) {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt"), StandardCharsets.UTF_8));
            final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt"), StandardCharsets.UTF_8))) {
            String line = reader.readLine();
            writer.write(line);
            writer.newLine();
        } catch (IOException exception) {
            System.err.println(exception.getMessage());
        }
        // List, LinkedList
    
        // Map, LinkedHashMap
        // key, value
        Map<String, Integer> dict = new LinkedHashMap<>();
        //dict.put("mike", 19);
        dict.put("jkfsl", 789);
        for (Map.Entry<String, Integer> item : dict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
        dict.put("mike", dict.getOrDefault("mike", 0) + 1);
        for (Map.Entry<String, Integer> item : dict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
