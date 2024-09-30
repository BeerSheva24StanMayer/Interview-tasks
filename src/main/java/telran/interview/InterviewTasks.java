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
        int i = 0;
        boolean res = false;
        while (!res && i < array.length) {
            int numberSecond = sum - array[i];
            
            if (checkingSet.contains(numberSecond)) {
                res = true;
            }
            checkingSet.add(array[i]);
            i++;
        }

        return res;
    }
}