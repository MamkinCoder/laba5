import java.io.FileNotFoundException;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        FileIO writter = new FileIO();
        try {
            PriorityQueue<Food> queue = writter.readQueue("data.txt");
            System.out.println("done");
        } catch (FileNotFoundException e) {
            System.out.println("Can't find file!");
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
