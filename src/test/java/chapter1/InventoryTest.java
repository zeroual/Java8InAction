package chapter1;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abdellah on 29/05/15.
 */
public class InventoryTest {

    private Inventory inventory;
    private List<Apple> apples;

    @Before
    public void  setUp()
    {
        apples = new ArrayList<>();
        apples.add(new Apple("green", 20));
        apples.add(new Apple("red", 12));
        apples.add(new Apple("blue", 30));
        apples.add(new Apple("green", 100));
        inventory = new Inventory(apples);
    }

    @Test
    public void shouldFilterGreenApples(){
        Assert.assertEquals(inventory.filterGreenApples().size(),2);
    }
    @Test
    public void shouldFilterHeavyApples(){
        Assert.assertEquals(inventory.filterHeavyApples().size(),1);
    }
    @Test
    public void shouldFilter(){
        Assert.assertEquals(inventory.filterApples(apple->apple.getWeight()>60).size(),1);

        Assert.assertEquals(inventory.filterApples(new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        }).size(),2);
    }
    @Test
    public void shouldSortByWeight(){
        // REAL EXAMPLE
        apples.sort(((o1, o2) -> o1.getWeight()-o2.getWeight()));
        System.out.println(apples);
        Assert.assertEquals(apples.get(0).getColor(),"red");
        Assert.assertEquals(apples.get(1).getColor(),"green");
        Assert.assertEquals(apples.get(2).getColor(),"blue");
        Assert.assertEquals(apples.get(3).getColor(),"green");

    }
}