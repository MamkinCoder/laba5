import com.google.gson.Gson;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Commands {




    static public PriorityQueue<Food> remove_all(String arg, PriorityQueue<Food> queue) {
        Gson gson = new Gson();
        Food food = new Food();
        try {
            food = gson.fromJson(arg, Food.class);
        }
        catch (Exception e){
            System.out.println("Неверный формат json");
        }

        Iterator it = queue.iterator();

        while(it.hasNext()) {
            if (food.equals(it.next()))
                it.remove();

        }

        return queue;

    }

    public static PriorityQueue<Food> import_cmd(String arg, PriorityQueue<Food> queue) {

        FileIO file = new FileIO();

        try {
            file.readQueue(arg, queue);
        }
        catch (Exception e)
        {
            System.out.println("Неверный путь к файлу!");
        }

        return queue;
    }

    public static PriorityQueue<Food> remove_greater(String arg, PriorityQueue<Food> queue) {

        Gson gson = new Gson();
        Food food = new Food();
        try {
            food = gson.fromJson(arg, Food.class);
        }
        catch (Exception e){
            System.out.println("Неверный формат json");
        }

        Iterator it = queue.iterator();

        while(it.hasNext()) {
            if (food.compareTo((Food)it.next()) < 0)
                it.remove();
        }

        return queue;
    }

    public static PriorityQueue<Food> add_if_max(String arg, PriorityQueue<Food> queue) {
        Gson gson = new Gson();
        Food food = new Food();
        try {
            food = gson.fromJson(arg, Food.class);
        }
        catch (Exception e){
            System.out.println("Неверный формат json");
        }

        Iterator it = queue.iterator();

        boolean check = true;

        while(it.hasNext()) {
            if (food.compareTo((Food)it.next()) < 0)
               check = false;

        }
        if (check)
            queue.add(food);

        return queue;
    }

    public static void info(PriorityQueue<Food> queue) {

        System.out.printf("Тип коллекции:" + Food.class.toString() + "%nКоличество элементов: " + queue.size() + "%n");


    }
}
