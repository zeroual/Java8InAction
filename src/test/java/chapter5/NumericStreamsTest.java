package chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

/**
 * Created by abdellah on 27/05/15.
 */
@RunWith(JUnit4.class)
public class NumericStreamsTest{

    private NumericStreams numericStreams;
    @Before
    public void setUp(){
        numericStreams = new NumericStreams();
    }
    @Test
    public void shouldReturnAllPythagoreanTriples(){
        List<int[]>triples=numericStreams.computeAllPythagoreanTriples();
        triples.stream().limit(5).forEach(t-> System.out.println(("("+t[0]+","+t[1]+","+t[2]+")")));


        Assert.assertTrue(Arrays.equals(triples.get(0), new int[]{3, 4, 5}));
        Assert.assertTrue(Arrays.equals(triples.get(1), new int[]{4, 3, 5}));
        Assert.assertTrue(Arrays.equals(triples.get(2), new int[]{5, 12, 13}));
        Assert.assertTrue(Arrays.equals(triples.get(3), new int[]{6, 8,  10}));
    }
}