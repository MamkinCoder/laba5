import java.io.*;
import java.util.*;

public class FileIO {

    public PriorityQueue<Food> readQueue(String path) throws FileNotFoundException {
        PriorityQueue<Food> readed = new PriorityQueue<>();
        Scanner scanner = new Scanner(new File(path));
        while (scanner.hasNext()){
            String line = scanner.nextLine();
            if (line.equals("")) continue;
            readed.add(parseFood(line));
        }
        return readed;
    }

    private Food parseFood(String line) {
        Food food = new Food();
        String[] fields = line.split(",");
        try {
            String[] date = fields[0].trim().split("-");
            food.setDate(Integer.parseInt(date[0]),Integer.parseInt(date[1]),Integer.parseInt(date[2]));
            food.setTaste(Food.TASTE.valueOf(fields[2].trim()));
            food.setName(fields[1].trim());
        } catch (Exception e){
            System.out.println("Wrong input line : " + line);
        }
        return food;
    }

    public boolean writeQueue(String path, PriorityQueue<Food> data){
        Boolean result = true;
        //тутачки нужно написать запись
        return result;
    }
}
