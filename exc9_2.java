import java.util.Scanner;

public class exc9_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String hexNumber;

        while (true) {
            System.out.print("Введите число в 16-ой системе счисления: ");
            hexNumber = input.nextLine().toUpperCase();

            boolean isValidHex = hexNumber.matches("[0-9A-F]+");
            if (isValidHex) {
                break;
            } else {
                System.out.println("Неверный ввод. В числе должны быть только символы 0-9 и A-F.");
            }
        }

        int decimalNumber = Integer.parseInt(hexNumber, 16);
        String ternaryNumber = Integer.toString(decimalNumber, 3);

        System.out.println("Число в 3-й системе счисления: " + ternaryNumber);
    }
}
