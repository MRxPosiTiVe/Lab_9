import java.util.*;

import static java.lang.Math.*;

public class exc9_4 {
    public static int some_line(Character[][] array, ArrayList<Integer> lst) {
        int counter = 0;

        for (int i = 0; i < array.length - 4; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (48 <= array[i][j] & array[i][j] <= 57 & 48 <= array[i + 1][j] & array[i + 1][j] <= 57
                        & 48 <= array[i + 2][j] & array[i + 2][j] <= 57 & 48 <= array[i + 3][j] & array[i + 3][j] <= 57
                & 48 <= array[i + 4][j] & array[i + 4][j] <= 57) {
                    if (((int) (array[i][j] - 48) + (int) (array[i + 1][j] - 48) *
                            ((int) (array[i + 2][j] - 48) - (int) (array[i + 3][j] - 48))) == (int) (array[i + 4][j] - 48)) {
                        System.out.println((int) (array[i][j] - 48) + " + " + (int) (array[i + 1][j] - 48) + " * (" + (int) (array[i + 2][j] - 48) + " - " +
                                (int) (array[i + 3][j] - 48) + ") = " + ((int) array[i + 4][j] - 48) + " (Правильный столбик)");
                        counter += 1;
                    } else {
                        System.out.println((int) (array[i][j] - 48) + " + " + (int) (array[i + 1][j] - 48) + " * (" + (int) (array[i + 2][j] - 48) + " - " +
                                (int) (array[i + 3][j] - 48) + ") = " + ((int) array[i + 4][j] - 48) + " (Неправильный столбик)");
                        lst.add((int) (array[i][j] - 48));
                        lst.add((int) (array[i + 1][j] - 48));
                        lst.add((int) (array[i + 2][j] - 48));
                        lst.add((int) (array[i + 3][j] - 48));
                    }
                }
            }
        }
        for (Character[] characters : array) {
            for (int j = 0; j < characters.length - 4; j++) {
                if (48 <= characters[j] & characters[j] <= 57 & 48 <= characters[j + 1] & characters[j + 1] <= 57
                        & 48 <= characters[j + 2] & characters[j + 2] <= 57 & 48 <= characters[j + 3] & characters[j + 3] <= 57
                        & 48 <= characters[j + 4] & characters[j + 4] <= 57) {
                    if ((int) (characters[j] - 48) + ((int) (characters[j + 1] - 48)
                            * ((int) (characters[j + 2] - 48)) - (int) (characters[j + 3] - 48)) == (int) (characters[j + 4] - 48)) {
                        System.out.println((int) (characters[j] - 48) + " + " + ((int) (characters[j + 1] - 48) + " * ("
                                + ((int) (characters[j + 2] - 48)) + " - " + (int) (characters[j + 3] - 48))
                                + ") =" + (int) (characters[j + 4] - 48) + " (Правильная строка)");
                        counter += 1;
                    } else {
                        System.out.println((int) (characters[j] - 48) + " + " + ((int) (characters[j + 1] - 48) + " * ("
                                + ((int) (characters[j + 2] - 48)) + " - " + (int) (characters[j + 3] - 48))
                                + ") = " + (int) (characters[j + 4] - 48) + " (Неправильная строка)");
                        lst.add((int) (characters[j] - 48));
                        lst.add((int) (characters[j + 1] - 48));
                        lst.add((int) (characters[j + 2] - 48));
                        lst.add((int) (characters[j + 3] - 48));
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int n = 6 + (int) (random() * 10);
        Character[][] array = new Character[n][n];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (char) (48 + (int) (random() * (64 - 48)));
            }
        }
        for (Character[] characters : array) {
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.print("\n");
        }
        System.out.print("Количество правильных: " + some_line(array, list) + "\nНеправильные:\n");

        for (int i = 0; i < list.size() - 3; i += 4) {
            System.out.println(list.get(i) + " + " + list.get(i + 1) + " * (" + list.get(i + 2) + " - "
                    + list.get(i + 3) + ") = " +
                    (list.get(i) + list.get(i + 1) * (list.get(i + 2) - list.get(i + 3))));
        }
    }
}
