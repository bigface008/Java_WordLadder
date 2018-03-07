import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        } else if (args[1].length() != args[2].length()) {
            System.out.println("The words must have the same length.");
            System.exit(1);
        }

        try {
            // Build the dictionary.
            Set<String> dictionary = dictionaryBuilder(args[0], args[1].length());

            // Try to find the shortest path.
            ladder(args[1], args[2], dictionary);

            System.exit(0);
        } catch (IOException e) {
            System.out.println("Wrong file name.");
            System.exit(1);
        }
    }

    static Set<String> dictionaryBuilder(String file_name, int len) throws IOException {
        File dic = new File(file_name);
        FileInputStream fin = new FileInputStream(dic);
        BufferedReader br = new BufferedReader(new InputStreamReader(fin));

        String line = null;
        Set<String> dictionary = new HashSet<>();
        while ((line = br.readLine()) != null)
            if (line.length() == len)
                dictionary.add(line);

        br.close();
        return dictionary;
    }

    static void ladder(String word_1, String word_2, Set<String> dictionary) {
        Queue<String> path = new LinkedList<>();
        Map<String, String> map_of_path = new HashMap<>();
        path.add(word_1);
        while (!path.isEmpty()) {
            String temp = path.poll();
            dictionary.remove(temp);
            ArrayList<String> neighbors = findNeighbors(temp, dictionary);
            for (String n : neighbors) {
                map_of_path.put(n, temp);
                if (n.equals(word_2)) {
                    System.out.println("Paths: " + findPath(map_of_path, word_1, word_2));
                    System.exit(0);
                }
                path.add(n);
            }
        }
        System.out.println("No such path between " + word_1 + " and " + word_2 + ".");
    }

    static ArrayList<String> findNeighbors(String word, Set<String> dictionary) {
        ArrayList<String> neighbors = new ArrayList<>();
        for (String str : dictionary) {
            int len = word.length();
            int check = 0;
            for (int i = 0; i < len; i++) {
                if (word.charAt(i) != str.charAt(i))
                    check++;
                if (check > 1)
                    break;
            }
            if (check == 1)
                neighbors.add(str);
        }
        return neighbors;
    }

    static String findPath(Map<String, String> map, String word_1, String word_2) {
        ArrayList<String> path = new ArrayList<>();
        path.add(word_2);
        String temp = map.get(word_2);
        while (!temp.equals(word_1)) {
            path.add(temp);
            temp = map.get(temp);
        }

        String result = "";
        for (String word : path) {
            result += (word + " ");
        }
        result += (word_1 + " ");
        return result;
    }
}