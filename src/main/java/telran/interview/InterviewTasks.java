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
        // TODO
        // rolesHistory is the list containg dates and roles assigned to the employees
        // at the appropriate dates
        // for example, date => 2019-01-01, role => Developer means that some employee
        // (no matter who) was taken
        // role Developer at 2019-01-01
        // create List<DateRole> with roles matching with the given dates
        // most effective data structure
        TreeMap<LocalDate, String> log = new TreeMap<>();
        rolesHistory.forEach(i -> log.put(i.date(), i.role()));
        List<DateRole> closestDates = dates.stream().map(date -> {
            LocalDate value = log.floorKey(date);
            String role = value != null ? log.get(value) : null;
            return new DateRole(date, role);
        }).toList();
        
        return closestDates;
    }

    public static boolean isAnagram(String word, String anagram) {
        HashMap<Character, Integer> letterMap = new HashMap<>();
        Boolean isAnagram = false;
        char[] chars = anagram.toCharArray();
        int i = 0;
        if (word.length() == anagram.length() && !word.equals(anagram)) {
            for (char ch : word.toCharArray()) {
                letterMap.put(ch, letterMap.getOrDefault(ch, 0) + 1);
            }
            while (i < chars.length && letterMap.containsKey(chars[i])) {
                letterMap.put(chars[i], letterMap.get(chars[i]) - 1);
                if (letterMap.get(chars[i]) == 0) {
                    letterMap.remove(chars[i]);
                }
                i++;
            }
            isAnagram = letterMap.isEmpty();
        }
        return isAnagram;
    }
}