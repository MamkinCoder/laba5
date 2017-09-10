import com.sun.javaws.exceptions.InvalidArgumentException;
import org.supercsv.io.ICsvBeanWriter;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static final String HELP = "TI OPIT VIHODISH NA SVAZ MUDILA";
    private static Boolean verbose = false;

    public static void main(String[] args) {
        if (Arrays.stream(args).anyMatch(x -> x.equals("-verbose"))) verbose = true;
        PriorityQueue<Food> queue = new PriorityQueue<>();
        Command importCommand = new Command("import data.txt",queue);
        try {
            importCommand.execute();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvalidArgumentException e) {
            e.printStackTrace();
        }

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
//                final_file.writeQueue(final_food);
                while(!queue.isEmpty()){
                    System.out.println(queue.poll().getExpirationDate());
                }
                System.out.println("rjhsnj");
            }
        }, "Shutdown-thread"));


        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            try {
                line = scanner.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                if (line.trim().startsWith("help")) {
                    show(HELP);
                } else {
                    Command command = new Command(line, queue);
                    String status = command.execute();
                    if (verbose) {
                        show(status);
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("До свидания");
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Неверное количество аргументов");
            } catch (NoSuchMethodException e) {
                System.out.println("Нет такой команды");
            } catch (InvalidArgumentException e) {
                e.printStackTrace();
            }
        }
    }

    private static void show(String str) {
        System.out.println(str);
    }
}
