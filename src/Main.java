import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;

/** Класс Main.
 * @author Ярослав
 * @author Денис
 * @version over 9000
 * @since 1.0
 */
public class Main {
    public static void main(String[] args) {


        String formatted = new String();
        FileIO file = new FileIO();
        PriorityQueue<Food> queue = new PriorityQueue<>();
        try {
            queue = file.readQueue(args[0]);
            System.out.println("Файл загружен верно");
            formatted =  new SimpleDateFormat("yyyy-MM-dd 'время:' HH:mm:ss").format(new Date(System.currentTimeMillis()));
        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти файл");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Невозможное количество аргументов командной строки");
        }

        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("quit")) {
                break;}
            String[] input = line.split(" ");
            try {
                    switch (input[0]) {
                        case "remove_all": queue = Commands.remove_all(input[1], queue);
                            break;
                        case "add_if_max": queue = Commands.add_if_max(input[1], queue);
                            break;
                        case "remove_greater": queue = Commands.remove_greater(input[1], queue);
                            break;
                        case "import": queue = Commands.import_cmd(input[1], queue);
                            break;
                        case "info": Commands.info(queue);
                            System.out.printf("Дата инициализации: " + formatted + "%nИмена элементов:%n");
                            int i=0;
                            for(Food s : queue) {
                                System.out.println(i + ") " + s.getName());
                                i++;}
                            break;
                        default: throw new NoSuchMethodException();

                    }

            }
            catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Неверное количество аргументов");
            }
            catch (NoSuchMethodException e){
                System.out.println("Нет такой команды");
            }
        }


        final PriorityQueue<Food> final_food = queue;

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                file.writeQueue(final_food);
            }
        }, "Shutdown-thread"));

    }
}
