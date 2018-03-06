import java.util.*;

/**
 * WordLabber
 * @author 516030910460
 * @version 0.0.1
 */
public class WordLabber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print(
                "Java Wordladder implemented by 516030910460.\nInput <quit> to quit the program.\nInput the file name: ");
        String filename = in.next();
        if (filename.equals("<quit>")) {
            in.close();
            System.exit(0);
        }

        System.out.print("Input the first word or input <quit> to quit the program: ");
        String word_1 = in.next();
        if (word_1.equals("<quit>")) {
            in.close();
            System.exit(0);
        }

        System.out.print("Input the second word or input <quit> to quit the program: ");
        String word_2 = in.next();
        if (word_2.equals("<quit>")) {
            in.close();
            System.exit(0);
        }

        ladder(word_1, word_2);
        in.close();
    }

    static void ladder(String word_1, String word_2) {
    }
}