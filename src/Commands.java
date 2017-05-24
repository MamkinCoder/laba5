import com.google.gson.Gson;

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

        queue.iterator()

        return queue;

    }

    public static PriorityQueue<Food> import_cmd(String arg, PriorityQueue<Food> queue) {

        return queue;
    }

    public static PriorityQueue<Food> remove_greater(String arg, PriorityQueue<Food> queue) {

        return queue;
    }

    public static PriorityQueue<Food> add_if_max(String arg, PriorityQueue<Food> queue) {
        return queue;
    }

    public static void info(PriorityQueue<Food> queue) {


    }
}
