import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class exc9_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите что-нибудь: ");
        String symbol = input.nextLine();

        System.out.println("Длина массива: ");
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
        System.out.printf("Символов введеных с клавиатуры: %d\n", sym_count);

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
        System.out.printf("Кол-во соседних закрытых скобок: %d\n", cout_brackets);

        int space_counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(" ")) space_counter++;
            else space_counter = 0;
            if (space_counter > 2) {
                System.out.println("Обнаружены более двух подряд идущих пробелов.");
                break;
            }
        }

        boolean foundSequence = false;
        for (int i = 0; i < arr.length - 3; i++) {
            // проверка условий для последовательности
            if (Character.isDigit(arr[i].charAt(0)) &&
                    Character.isDigit(arr[i + 1].charAt(0)) &&
                    Character.isDigit(arr[i + 2].charAt(0))) {
                int num1 = Integer.parseInt(arr[i]);
                int num2 = Integer.parseInt(arr[i + 1]);
                int num3 = Integer.parseInt(arr[i + 2]);
                if (num1 > num2 && num2 > num3) { // первые две цифры убывающие, последняя возрастающая
                    foundSequence = true;
                    break;
                }
            }
        }
        if (foundSequence) {
            System.out.println("Существуют такие натуральные i и j, что i<k<j<п и " +
                    "si, и si+1 убывающая последовательность цифр, a sj и sj+1 возрастающая последовательность цифр.");
        } else {
            System.out.println("Не найдено таких натуральных i и j, что i<k<j<п и " +
                    "si, и si+1 убывающая последовательность цифр, a sj и sj+1 возрастающая последовательность цифр.");
        }

    }
}
