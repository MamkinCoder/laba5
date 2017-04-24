import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Comparator<String> comparator = new Stringlength();
        PriorityQueue<String> fpq1=new PriorityQueue<String>(10);
        fpq1.add("sasaliti ");
        fpq1.add("kaka");
        fpq1.add("le");
        while(fpq1.size()!=0)
        {
            System.out.println(fpq1.remove());
        }
        Food f1 = new Food();
        Food f2 = new Food();
        f2.setDate(2990, 1, 2);
        System.out.println(f1.compareTo(f2));


    }
}
