package chapter5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by abdellah on 27/05/15.
 */
public class NumericStreams {


    public List<int[]> computeAllPythagoreanTriples() {
        return IntStream.rangeClosed(1, 100).boxed().flatMap(
                a -> IntStream.rangeClosed(1, 100).filter(b -> Math.sqrt(a * a + b * b)%1==0)
                        .mapToObj(b -> new int[]{a, b, (int) Math.sqrt(a * a + b * b)}))
                .collect(Collectors.toList());
    }
}
