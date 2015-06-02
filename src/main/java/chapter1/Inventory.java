package chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdellah on 29/05/15.
 */
public class Inventory {

    private List<Apple> apples;

    public Inventory(List<Apple> apples) {

        this.apples = apples;
    }

    public List<Apple> filterGreenApples() {
        List<Apple> res=new ArrayList<>();
        for (Apple apple : apples) {
            if("green".equals(apple.getColor())) {
                res.add(apple);
            }
        }
        return res;
    }

    public List<Apple> filterHeavyApples() {
        List<Apple> res=new ArrayList<>();
        for (Apple apple : apples) {
            if(apple.getWeight()>60) {
                res.add(apple);
            }
        }
        return res;
    }


    public List<Apple> filterApples(ApplePredicate predicate) {
        List<Apple> res=new ArrayList<>();
        for (Apple apple : apples) {
            if(predicate.test(apple)) {
                res.add(apple);
            }
        }
        return res;
    }
}
