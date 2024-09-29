package telran.interview;

import java.util.*;
import java.util.stream.IntStream;

public class InterviewTasks {
/**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *  summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int [] array, int sum) {
        Set<Integer> checkingSet = new HashSet<>();
        return IntStream.of(array).anyMatch(i -> checkingSet.contains(sum - i) || !checkingSet.add(i));
    }
}