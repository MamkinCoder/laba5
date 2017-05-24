import  java.util.GregorianCalendar;

public class Food implements  Comparable<Food> {
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

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Food other){
        return this.getExpirationDate().compareTo(other.getExpirationDate());
    }

    @Override
    public boolean equals(Object obj){

        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        /* Check if obj is an instance of Food or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Food)) {
            return false;
        }

        Food other = (Food) obj;
        if (this.expirationDate.equals(other.expirationDate)
                && this.name.equals(other.name)
                && this.taste == other.taste
        )
            return true;
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }


}
