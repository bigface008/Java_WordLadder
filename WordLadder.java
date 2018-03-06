import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.*;

/**
 * WordLadder
 * @author 516030910460
 * @version 0.0.1
 */
public class WordLadder {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Args are not enough.");
            System.exit(1);
        }

        try {
            // Build the dictionary.
            Set<String> dictionary = dictionaryBuilder(args[0]);

            // Try to find the shortest path.
            ladder(args[1], args[2], dictionary);

            System.exit(0);
        } catch (IOException e) {
            System.out.println("Wrong file name.");
            System.exit(1);
        }
    }

    static Set<String> dictionaryBuilder(String file_name) throws IOException {
        File dic = new File(file_name);
        FileInputStream fin = new FileInputStream(dic);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));

        String line = null;
        Set<String> dictionary = new HashSet<>();
        while ((line = br.readLine()) != null) {
            dictionary.add(line);
        }

        br.close();
        return dictionary;
    }

    static void ladder(String word_1, String word_2, Set<String> dictionary) {
        if (word_1.length() != word_2.length()) {
            System.out.println("The words must have the same length.");
            System.exit(1);
        }

        Set<String> small_dictionary = new HashSet<>();
        for (String str : dictionary)
            if (str.length() == word_1.length())
                small_dictionary.add(str);
        
        int size_of_dictionary = small_dictionary.size();
        List<String> path = new LinkedList<>();
    }
}