import java.util.Scanner;

public class exc9_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите текст который содержать цифры: ");
        String text = input.nextLine();

        int mult = 1;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (Character.isDigit(ch)) mult *= ((int) (ch) - 48);
        }

        System.out.println(mult);

    }
}
