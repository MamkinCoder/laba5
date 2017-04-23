import  java.util.Date;

public abstract class Food implements Nameable {
    private TASTE taste;
    private Date expirationDate;
    private String name;

    Food(TASTE teaste, String name) {
        this.taste = teaste;
        this.name = name;
        this.expirationDate = new Date();
    }
    @Override
    public String getName() {
        return name;
    }

    public Date getExpirationDate() {
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
        SPICY
    }
}
