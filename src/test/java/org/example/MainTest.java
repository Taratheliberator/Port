package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {

    @Test
    public void testTransform() {
        String[] indexes = {"1,3-5", "2", "3-4"};
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 4),
                Arrays.asList(3, 2, 3),
                Arrays.asList(3, 2, 4),
                Arrays.asList(4, 2, 3),
                Arrays.asList(4, 2, 4),
                Arrays.asList(5, 2, 3),
                Arrays.asList(5, 2, 4)
        );

        List<List<Integer>> result = Main.transform(indexes);
        Assert.assertEquals(expected, result);
    }
}
