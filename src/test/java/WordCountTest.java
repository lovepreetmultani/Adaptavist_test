
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCountTest {

    @Test
    public void testWordCount() throws IOException {
        Map<String, Integer> wordCount = WordCount.countWordsInFile("/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/input.txt");
        assertEquals(6, wordCount.get("eget"));
        assertEquals(5, wordCount.get("et"));
        assertEquals(4, wordCount.get("id"));
        assertEquals(3, wordCount.get("arcu"));
        assertEquals(2, wordCount.get("tempus"));
        assertEquals(2, wordCount.get("sit"));
        assertEquals(1, wordCount.get("mollis"));

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
