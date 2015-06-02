package chapter5.transactions;

/**
 * Created by abdellah on 21/05/15.
 */
public class Trader {
    private final String name;
    private final String city;

    public Trader(String name, String city) {

        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
