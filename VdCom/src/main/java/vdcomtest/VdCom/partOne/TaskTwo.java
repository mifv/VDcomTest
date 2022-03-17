package vdcomtest.VdCom.partOne;

import javax.sound.midi.Patch;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 2. Консольное приложение:
 * На вход передается целое число, больше 0, кратное 2 (n). Создается файл с именем
 * out.txt, в который пишется значение 0. Создается два потока, работающих
 * параллельно, каждый поток в цикле, считывает значение из файла out.txt увеличивает
 * его на 1, выводит в консоли старое значение, новое значение и идентификатор потока
 * (идентификатор может быть произвольным), и записывает обратно в файл.
 * В конечном итоге оба потока должны успешно завершить свою работу, и в консоль
 * должно вывестись содержимое файла out.txt (которое должно быть равно заданному
 * на входе n).
 */
public class TaskTwo {
    private static Scanner scanner = new Scanner(System.in);
    private final static int LOW = 0;
    private final static int MULTIPLE = 2;
    private final static int THREADS = 2;

    private static final Path FILEP = Paths.get("out.txt");

    public static void main(String[] args) {
        System.out.println("Введите целое число больше 0 и кратное 2:");
        int enteredNumber = numberFromInput();
        initFile();
        threadRun(enteredNumber);
    }

    public static int numberFromInput() {
        int number = scanner.nextInt();
        if (!valid(number)) {
            throw new IllegalArgumentException("Вы ввели некорректное число.Введите число больше" + LOW + "и кратное" + MULTIPLE);
        }
        return number;
    }

    public static boolean valid(int enteredNumber) {
        return enteredNumber > LOW && enteredNumber % MULTIPLE == 0;
    }

    static void initFile() {
        try {
            if (Files.notExists(FILEP)) {
                Files.createFile(FILEP);
            }
            Files.write(FILEP, "0".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
static void threadRun(int enteredNumber) {
ExecutorService executor =Executors.newFixedThreadPool(THREADS);
ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    for (int i = 0; i <THREADS ; i++) {
        executor.submit( () -> {
            while( true )
            {
                try {
                    readWriteLock.readLock().lock();
                    int number = Integer.parseInt( Files.readString( FILEP ));
                    if( number >= enteredNumber )
                        break;
                    readWriteLock.readLock().unlock();

                    System.out.println( Thread.currentThread().getName() + " - старое значение: " + number + "; новое значение:" + ++number );

                    readWriteLock.writeLock().lock();
                    try {
                        if( Integer.parseInt( Files.readString(FILEP)) < enteredNumber )
                            Files.writeString( FILEP, String.valueOf( number ));
                    }
                    finally {
                        readWriteLock.writeLock().unlock();
                    }
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println( "Итоговое число в out.txt: " + Files.readString( FILEP));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    executor.shutdown();
}
}




