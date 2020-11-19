package main.java.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author regotto
 */
public class Lc406QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        return people;
    }

}
