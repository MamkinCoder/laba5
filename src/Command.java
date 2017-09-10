import com.sun.javaws.exceptions.InvalidArgumentException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

public class Command {

    String nameAndArgs;
    PriorityQueue<Food> queue;
    Food element;

    public Command(String nameAndArgs, PriorityQueue<Food> queue) {
        this.nameAndArgs = nameAndArgs;
        this.queue = queue;
    }

    public String execute() throws NoSuchMethodException, InvalidArgumentException{
        String[] input = nameAndArgs.split(" ");
        String command = input[0];
        if (command.equals("info")) return getInfo();
        if (command.equals("import")) return loadDataFrom(input[1]);
        element = castToFood(input[1]);
        switch (command) {
            case "remove_all":  removeAll();
                break;
            case "add_if_max": addIfMax();
                break;
            case "remove_greater": removeGreater();
                break;
            default: throw new NoSuchMethodException();

        }
        return getState();
    }

    private void removeGreater() {
        while (!queue.isEmpty() && queue.poll().getExpirationDate().compareTo(element.getExpirationDate()) == -1){
            queue.peek();
        }

    }

    private void addIfMax() {
        if (queue.peek().compareTo(element) > 0)
            queue.add(element);
        //add_if_max {"taste":"SWEET","expirationDate":"2017-05-21","name":"Apple"}
    }

    private void removeAll() {
        queue.removeIf(x->x.equals(element));
        //remove_all {"taste":"SWEET","expirationDate":"2017-05-15","name":"Apple"}
    }

    private Food castToFood(String s) throws InvalidArgumentException {
        JSONObject parser = new JSONObject(s);
        element = new Food();
        element.setDate(parser.getString("expirationDate"));
        element.setName(parser.getString("name"));
        element.setTaste(parser.getString("taste"));
        return element;
    }

    private String loadDataFrom(String s) {
        FileIO writter = new FileIO();
        try {
            queue.addAll(writter.readQueue(s));
            System.out.println("done");
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file!");
        }
        return getState();
    }

    public String getInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        JSONArray array = new JSONArray();
        queue.forEach(el -> array.put(new JSONObject().put("name", el.getName())
        .put("taste", el.getTaste()).put("expirationDate", sdf.format(new Date(el.getExpirationDate().getTimeInMillis())))));
        System.out.println(array.toString());
        return getState();
    }

    public String getState() {
        return "NotImplementedYet!";
    }
}
