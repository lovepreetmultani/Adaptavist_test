import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.*;
import java.util.stream.Collectors;

class WordCount {

    public static Map<String, Integer> countWordsInFile(String filename) throws IOException {
        Map<String, Integer> wordCounter = new HashMap<>();
        try (BufferedReader reader =new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split by whitespace
                for (String word : words) {
                    word = word.toLowerCase().replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                    if (!word.isEmpty()) {
                        wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        return wordCounter.isEmpty() ? null : wordCounter;
    }

    public static void printWordCount(Map<String, Integer> wordCount) {
        if(wordCount!=null)
        {
            List<Map.Entry<String, Integer>> sortedList = wordCount.entrySet()
                    .stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .collect(Collectors.toList());

            for (Map.Entry<String, Integer> entry : sortedList) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        else{
            System.err.println("No words found in the file.");
        }
    }
    public static void main(String[] args) {
        String filename = "/src/main/resources/input.txt";
        try {
            Map<String, Integer> wordCount = countWordsInFile(filename);
            if (wordCount != null) {
                printWordCount(wordCount);
            } else {
                System.err.println("No words found in the file.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


