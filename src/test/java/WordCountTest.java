
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertNull;

public class WordCountTest {

    private WordCount wordCount;

    @BeforeEach
    public void setUp() {
        wordCount = new WordCount();
    }

    @Test
    public void testWordCount() throws IOException {
        Map<String, Integer> wordCount = WordCount.countWordsInFile("/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/input.txt");
        assertEquals(6, wordCount.get("eget"));
        assertEquals(5, wordCount.get("in"));
        assertEquals(4, wordCount.get("id"));
        assertEquals(3, wordCount.get("arcu"));
        assertEquals(2, wordCount.get("tempus"));
        assertEquals(2, wordCount.get("sit"));
        assertEquals(1, wordCount.get("mollis"));

    }

    @Test
    public void testEmptyFile() throws IOException {
        Map<String, Integer> result = wordCount.countWordsInFile("/Users/lovepreetmultani/Downloads/adaptavist_test/src/main/resources/empty_file.txt");
        assertNull(result);
    }

    @Test
    public void testNonExistentFile() {
        try {
            Map<String, Integer> wordCount = WordCount.countWordsInFile("non-existent-file.txt");
        } catch (IOException e) {
            // We expect an exception for a non-existent file
            assertEquals("non-existent-file.txt (No such file or directory)", e.getMessage());
        }
    }
}
