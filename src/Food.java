import  java.util.GregorianCalendar;

public class Food implements Nameable, Comparable<Food> {
    private TASTE taste;
    private GregorianCalendar expirationDate;
    private String name;

    Food(){
        this.name = "default";
        this.expirationDate = new GregorianCalendar(2000, 1, 1);
    }

    Food(TASTE taste, String name) {
        this.taste = taste;
        this.name = name;
        this.expirationDate = new GregorianCalendar();
    }

    public void setDate(int year, int month, int day){
        this.expirationDate = new GregorianCalendar(year, month, day);
    }

    public GregorianCalendar getExpirationDate() {
        return expirationDate;
    }

    public TASTE getTaste() {
        return taste;
    }

    public void setTaste(TASTE teaste) {
        this.taste = teaste;
    }

    enum TASTE{
        SALTY,
        SWEET,
        SPICY,
        NONE
    }

    @Override
    public int compareTo(Food other){
        return this.getExpirationDate().compareTo(other.getExpirationDate());
    }

    @Override
    public String getName() {
        return name;
    }
}
