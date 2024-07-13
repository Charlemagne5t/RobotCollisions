import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {
    @Test
    public void test1() {
        int[] positions = {3,5,2,6};
        int[] healths = {10,10,15,12};
        String directions = "RLRL";
        List<Integer> expected = new ArrayList<>(List.of(14));
        List<Integer> actual = new Solution().survivedRobotsHealths(positions,healths,directions);

        Assert.assertEquals(expected, actual);
    }
}
