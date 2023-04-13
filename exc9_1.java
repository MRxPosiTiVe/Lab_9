import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exc9_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        char[] arr = new char[10];
        String alphabet = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String[] chars = new String[10];

        for (int i = 0; i < 10; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            chars[i] = String.valueOf(c);
        }
        System.out.println(Arrays.toString(chars));

        for (int i = 0; i < 10; i++) {
            arr[i] = chars[i].charAt(0);
        }

        for (int i = 1; i < arr.length; i++) {
            if (!Character.isUpperCase(arr[i])) {
                arr[i - 1] = ' ';
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
