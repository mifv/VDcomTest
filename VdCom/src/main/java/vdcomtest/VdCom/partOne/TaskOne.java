package vdcomtest.VdCom.partOne;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;

import java.util.Scanner;
import java.util.stream.Stream;


/**
 * 1. Консольное приложение - FooBar
 * На вход приложение получает целое число больше 0 (n), далее в консоль выводится
 * следующее, все числа от 1 до n, при этом:
 * ● Если число кратно 3, выводится Foo;
 * ● Если число кратно 5, выводится Bar;
 * ● Если число кратно и 3, и 5, выводится FooBar;
 * ● Если число не кратно 3 или 5, выводится само число.
 */
public class TaskOne {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int firstN;
        int secondN;
        while (true) {
            try {
                System.out.println(" Введите первое число больше 0: ");
                firstN = getFromNumber(0);
                System.out.println("Введите первое число больше:" + firstN + ":");
                secondN = getFromNumber(firstN);
                System.out.println("Использовать решение 1. Цикл и ветвления");
                solutionOne(firstN, secondN);
                System.out.println("Использовать решение 2. Функциональные интерфейсы и Stream API");
                solutionTwo(firstN, secondN);
                System.out.println("Использовать решение 3.Тернарный оператор");
                solutionThree(firstN, secondN);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int getFromNumber(int low) {
        int number = scanner.nextInt();
        if (!inputValid(low, number)) {
            throw new IllegalArgumentException("Вы ввели некорректное число.Число должно быть больше числа" + low);
        }
        return number;
    }

    public static boolean inputValid(int low, int enteredN) {
        return enteredN > low;
    }

    /**
     * Решение номер 1. Цикл и вветления
     */

    static void solutionOne(int firstN, int secondN) {
        for (int i = firstN; i <= secondN; i++) {
            float n3 = i % 3;
            float n5 = i % 5;
            if (n3 == 0 && n5 != 0) {
                System.out.println("Foo");
                continue;
            } else if (n3 != 0 && n5 == 0) {
                System.out.println("Bar");
                continue;
            } else if (n3 == 0 && n5 == 0) {
                System.out.println("FooBar");
                continue;
            }
            System.out.println(i);
        }
    }

    /**
     * Решение номер 2. Функциональный интерфейс и Stream API
     */
    static void solutionTwo(int firstN, int secondN) {
        Stream.iterate(firstN, integer -> integer + 1).limit(secondN).forEach((x) -> {
            if (x % 3 == 0 && x % 5 != 0)
                System.out.println("Foo");
            else if (x % 3 != 0 && x % 5 == 0)
                System.out.println("Bar");
            else if (x % 3 == 0)
                System.out.println("FooBar");
            else System.out.println(x);
        });

    }

    /**
     * Решение номер 3. Тернарный оператор
     */
    static void solutionThree(int firstN, int secondN) {
        while (true) {
            int three = scanner.nextInt();
            String input = ((three > 0 && three % 3 == 0 && three % 5 == 0) ? "FooBar" :
                    (((three > 0 && three % 5 == 0)) ? "Bar" :
                            (((three > 0 && three % 3 == 0)) ? "Foo"
                                    : String.valueOf(three))));
            System.out.println(input);

        }
    }
}