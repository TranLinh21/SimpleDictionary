import java.util.ArrayList;
import java.util.List;

public class Dictionary {
     static List<Word> words = new ArrayList<>();
    public static void addWord(String target, String explain) {
        words.add(new Word(target, explain));
    }
}
