import java.util.Scanner;

public class exc9_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Текст с такой херней --> ! <-- : ");
        String text = input.nextLine();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '!') {
                text = text.substring(0, i) + Integer.toString(i) + text.substring(i + 1);
            }
        }
        System.out.println(text);
    }
}
