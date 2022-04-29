package be.intectbrussel;
import java.io.Serializable;

public class RedPanda implements Serializable {

    String name;
    boolean edible;

    public RedPanda(String name, boolean edible) {
        this.name = name;
        this.edible = edible;
    }

    @Override
    public String toString() {
        return "RedPanda{" +
                "name='" + name + '\'' +
                ", edible=" + edible +
                '}';
    }
}
