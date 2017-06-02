import com.google.gson.Gson;
import java.util.Iterator;
import java.util.PriorityQueue;


/** Команды для ввода в консоль.
 * @author Ярослав
 * @author Денис
 * @version over 9000
 * @since 1.0
 */
public class Commands {

    /** если была команда 'remove_all'.
     * @param arg аргумент в формате json.
     * @param queue наша коллекция объектов типа Food.
     * @return Измененную коллекцию.
     */
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

    /** если была команда 'import'.
     * @param arg аргумент в формате json.
     * @param queue наша коллекция объектов типа Food.
     * @return Измененную коллекцию.
     */
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

    /** если была команда 'remove_greater'.
     * @param arg аргумент в формате json.
     * @param queue наша коллекция объектов типа Food.
     * @return Измененную коллекцию.
     */
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

    /** если была команда 'add_if_max'.
     * @param arg аргумент в формате json.
     * @param queue наша коллекция объектов типа Food.
     * @return Измененную коллекцию.
     */
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

    /** если была команда 'info'.
     * @param queue наша коллекция объектов типа Food.
     * @return Информация о коллекции.
     */
    public static void info(PriorityQueue<Food> queue) {

        System.out.printf("Тип коллекции:" + Food.class.toString() + "%nКоличество элементов: " + queue.size() + "%n");


    }
}
