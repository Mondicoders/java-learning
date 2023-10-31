import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordStatInput {
    private static List<String> def(String line) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> arr = new LinkedList<>();
        for (char arg: line.toCharArray()) {
            if (Character.isLetter(arg)  || arg=='\'' ||  Character.getType(arg)==Character.DASH_PUNCTUATION) {
                stringBuilder.append(Character.toLowerCase(arg));
            }
            else if (!stringBuilder.isEmpty()){
                arr.add(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
        if (!stringBuilder.isEmpty()){

            arr.add(stringBuilder.toString());
            stringBuilder.setLength(0);
        }
        return arr;
    }
    public static void main(String[] args) {
        try (final MyScanner reader = new MyScanner(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
        final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8))) {
            Map<String, Integer> dict = new LinkedHashMap<>();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
				List<String> arr = def(line);
                for (String el: arr) {

                    dict.put(el, dict.getOrDefault(el, 0) + 1);
                }
            }
            for (Map.Entry<String, Integer> item : dict.entrySet()) {
                writer.write(item.getKey() + " " + item.getValue());
                writer.newLine();
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
