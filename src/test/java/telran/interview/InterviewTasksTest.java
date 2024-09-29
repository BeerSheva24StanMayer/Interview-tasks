package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static telran.interview.InterviewTasks.*;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    @Test
    void hasSumTwoTest() {
        int[] array = { 10, 39, 51 };
        assertTrue(hasSumTwo(array, 90));
        assertFalse(hasSumTwo(array, 62));

    }
}