import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exc9_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите любую хуйню: ");
        String symbol = input.nextLine();

        System.out.println("Длина массива епта: ");
        int len = input.nextInt();

        String[] arr = new String[len];
        String alphabet = "ё1234567890-=йцукенгшщзхъфывапролджэячсмитьбю.!№;%:?*()_+, /[]{}@#$^&~ЁЙЦУ" +
                "КЕНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮqwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            char c = alphabet.charAt(random.nextInt(alphabet.length()));
            arr[i] = String.valueOf(c);
        }

        System.out.println(Arrays.toString(arr));

        int counter = 0;

        for (String s : arr) {
            boolean letters = s.matches("[а-яa-z]");
            if (letters) counter++;
        }
        System.out.printf("Кол-во строчных букв %d\n", counter);

        int sym_count = 0;

        for (String s : arr) {
            if (s.equals(symbol)) sym_count++;
        }
        System.out.printf("Символов введеных с клавиатуры %d\n", sym_count);

        if (symbol.matches("[0-9]+")) {
            int digit = Integer.parseInt(symbol);
            int digitCountInArray = 0;
            for (String s : arr) {
                if (s.matches("\\d") && Integer.parseInt(s) == digit) {
                    digitCountInArray++;
                }
            }
            if (digitCountInArray >= 2) {
                System.out.println("Среди символов есть 2 и более цифры, входящие в цифру " + digit);
            }
        } else {
            System.out.println("Херня введенная с клавиатруры не число!");
        }

        int cout_brackets = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].matches("\\(\\[\\{") && arr[i + 1].matches("\\)\\]\\}")) cout_brackets++;
        }
        System.out.println(cout_brackets);

        int space_counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) space_counter++;
            else space_counter = 0;
            if (space_counter > 2) {
                System.out.println("Обнаружены более двух подряд идущих пробелов.");
                break;
            }
        }
    }
}
