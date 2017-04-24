public class Main {
    public static void main(String[] args) {
        Food f1 = new Food();
        Food f2 = new Food();
        f2.setDate(2990, 1, 2);
        System.out.println(f1.compareTo(f2));
    }
}
