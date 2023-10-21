
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    @Test
    public void testWordCount() throws IOException {
        Map<String, Integer> wordCount = WordCount.countWordsInFile("/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/input.txt");
        assertEquals(8, wordCount.get("the"));
        assertEquals(4, wordCount.get("in"));
        assertEquals(3, wordCount.get("java"));
        assertEquals(2, wordCount.get("is"));
        assertEquals(1, wordCount.get("programming"));
        assertEquals(1, wordCount.get("language"));
    }

    @Test
    public void testEmptyFile() throws IOException {
        Map<String, Integer> wordCount = WordCount.countWordsInFile("/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/empty_file.txt");
        assertEquals(0, wordCount.size());
    }

    @Test
    public void testNonExistentFile() {
        try {
            Map<String, Integer> wordCount = WordCount.countWordsInFile("nonexistent.txt");
        } catch (IOException e) {
            // We expect an exception for a non-existent file
            assertEquals("Error reading the file: non-existent.txt (No such file or directory)", e.getMessage());
        }
    }
}
