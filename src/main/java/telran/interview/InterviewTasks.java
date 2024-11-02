package telran.interview;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
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

    static public int getMaxWithNegativePresentation(int[] array) {
        Set<Integer> numbers = new HashSet<>();
        int i = 0;
        int max = -1;
        while (i < array.length) {
            if (numbers.contains(-array[i]) && Math.abs(array[i]) > max) {
                max = Math.abs(array[i]);
            }
            numbers.add(array[i++]);
        }
        return max;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {

        TreeMap<LocalDate, String> map = new TreeMap<>();
        rolesHistory.forEach(i -> map.put(i.date(), i.role()));

        List<DateRole> closestDates = dates.stream().map(date -> {
            LocalDate value = map.floorKey(date);
            String role = value != null ? map.get(value) : null;
            return new DateRole(date, role);
        }).toList();

        return closestDates;
    }

    public static boolean isAnagram(String word, String anagram) {
        boolean result = false;
        if(word.length() == anagram.length() && !word.equals(anagram)) {
            HashMap<Integer, Integer> words = mapOfWord(word);
            result = isEqual(anagram, words);
        }
        return result;
    }

    private static boolean isEqual(String anagram, HashMap<Integer, Integer> words) {
        return anagram.chars().allMatch(echar -> words.compute(echar, (k, v) -> v == null ? -1 : v - 1) > -1);
    }

    private static HashMap<Integer, Integer> mapOfWord(String word) {
        HashMap <Integer, Integer> charsMap = new HashMap<>();
        word.chars().forEach(echar -> charsMap.merge(echar, 1, Integer::sum));
        return charsMap;
    }
}