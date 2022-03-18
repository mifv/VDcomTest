package vdcomtest.VdCom.partOne.TaskThree;

import vdcomtest.VdCom.partOne.TaskThree.classes.MathByte;
import vdcomtest.VdCom.partOne.TaskThree.classes.MathGir;
import vdcomtest.VdCom.partOne.TaskThree.classes.MathPir;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 3. Консольное приложение:
 * Дан перевод некоторых величин в формате a V = b W, где a, b – числа; V, W –
 * названия величин (могут быть любые), следом дана последовательность с
 * неизвестным вторым числом в формате a V = ? W, необходимо найти величину,
 * обозначенную в пропорции знаком вопроса. Ввод данных и вывод результата
 * осуществляются через стандартные потоки ввода/вывода.
 * Выходной формат a V = b W. Каждое равенство пишется на отдельной строке.
 * Постарайтесь максимально продемонстрировать свои знания ООP/OOD.
 * Код должен соответствовать критериям коммерческого качества кода.
 * Пример:
 * Вход:
 * 1024 byte = 1 kilobyte
 * 2 bar = 12 ring
 * 16.8 ring = 2 pyramid
 * 4 hare = 1 cat
 * 5 cat = 0.5 giraffe
 * 1 byte = 8 bit
 * 15 ring = 2.5 bar
 * 1 pyramid = ? bar
 * 1 giraffe = ? hare
 * 0.5 byte = ? cat
 * 2 kilobyte = ? bit
 * Выход:
 * 1 pyramid = 1.4 bar
 * 1 giraffe = 40 hare
 * Conversion not possible.
 * 2 kilobyte = 16384 bit
 */
public class Main {

    public static void main(String[] args) {

        String output = "1024 byte = 1 kilobyte \n" +
                "\n" +
                "2 bar = 12 ring \n" +
                "\n" +
                "16.8 ring = 2 pyramid \n" +
                "\n" +
                "4 hare = 1 cat \n" +
                "\n" +
                "5 cat = 0.5 giraffe \n" +
                "\n" +
                "1 byte = 8 bit \n" +
                "\n" +
                "15 ring = 2.5 bar\n";

        System.out.println(output);

        System.out.println("1 pyramid = ? bar\n" +
                "1 giraffe = ? hare\n" +
                "0.5 byte = ? cat\n" +
                "2 kilobyte = ? bit");

        MathGir mgr = new MathGir();
        MathByte mbt = new MathByte();
        MathPir mpr = new MathPir();


        try {

            Scanner sc2 = new Scanner((System.in));
            System.out.println("How many piramids do you have transfer in bars?");
            double pir = sc2.nextDouble();

            Scanner sc1 = new Scanner((System.in));
            System.out.println("How many giraffes do you have transfer in hares?");
            double gir = sc1.nextDouble();

            Scanner sc3 = new Scanner((System.in));
            System.out.println("How many cats do you have transfer in bytes?");
            double cats = sc3.nextDouble();

            Scanner sc = new Scanner((System.in));
            System.out.println("How many kilobytes do you have transfer in bits?");
            double kB = sc.nextDouble();
            DecimalFormat decimalFormat = new DecimalFormat("#.###");

            System.out.println(pir + " pyramid = " + decimalFormat.format(mpr.MathPir(pir)) + " bar\n" +
                    gir + " giraffe = " + decimalFormat.format(mgr.MatchGir(gir)) + " hare\n" +
                    "Conversion not possible.\n" +
                    kB + " kilobyte = " + decimalFormat.format(mbt.MathByte(kB)) + " bit");
        } catch (InputMismatchException e) {

            System.out.println("необходимо ввести цифровые данные");


        }

    }
}







