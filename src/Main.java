import com.google.gson.Gson;
import com.sun.xml.internal.ws.api.model.CheckedException;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        FileIO file = new FileIO();
        PriorityQueue<Food> queue = new PriorityQueue<>();
        try {
            queue = file.readQueue(args[0]);
            System.out.println("Файл загружен верно");
        } catch (FileNotFoundException e) {
            System.out.println("Не могу найти файл");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Невозможное количество аргументов командной строки");
        }

////        for(Food s : queue) {
////            System.out.println(s.getName());
////        }
//
//        Food food = new Food(Food.TASTE.SWEET, "Apple");
//        food.setDate(2017, 05, 10);
//
//
//        Gson gson = new Gson();
//        String jsonInString = gson.toJson(food);
//
//
//        Food food2 =  gson.fromJson(jsonInString, Food.class);
//
//        //System.out.println(jsonInString);




        Scanner scanner = new Scanner(System.in);
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("quit"))
                break;
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
                            break;
                        default: throw new NoSuchMethodException();

                    }

                      for(Food s : queue) {
                         System.out.println(s.getName());}

            }
            catch (ArrayIndexOutOfBoundsException e){
//                System.out.printf("Неизвестная команда.%nСписок возможных команд: %nremove_all {element}: удалить из коллекции все элементы, эквивалентные заданному\n" +
//                        "add_if_max {element}: добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
//                        "remove_greater {element}: удалить из коллекции все элементы, превышающие заданный\n" +
//                        "import {String path}: добавить в коллекцию все данные из файла\n" +
//                        "info: вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)%n");
                System.out.println("Неверное количество аргументов");
            }
            catch (NoSuchMethodException e){
                System.out.println("Нет такой команды");
            }
        }




        /*
        Food f1 = new Food();
        Food f2 = new Food();
        f2.setDate(2990, 1, 2);
        System.out.println(f1.compareTo(f2));
        System.out.println("lallka");
        */
    }
}
