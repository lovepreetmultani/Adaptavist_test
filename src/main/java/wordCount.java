import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.*;

class WordCount {
    public static Map<String, Integer> countWordsInFile(String filename) throws IOException {
        Map<String, Integer> wordCounter = new HashMap<>();
        try (BufferedReader reader =new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" "); // Split by whitespace
                for (String word : words) {
                    word = word.toLowerCase(); // Convert to lowercase for case insensitivity
                    wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
                }
            }
        }catch(IOException e){
            System.out.println("IOException in try block =>" + e.getMessage());
        }
        return wordCounter;
    }

    public static void printWordCount(Map<String, Integer> wordCount) {
        List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<>(wordCount.entrySet());
        sortedEntries.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())); // Sort by frequency

        for (Map.Entry<String, Integer> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        String filename = "/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/input.txt";
        try {
            Map<String, Integer> wordCount = countWordsInFile(filename);
            printWordCount(wordCount);
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}
