package seedu.address.model.day.calorie;



import org.junit.jupiter.api.Test;

import seedu.address.model.day.Day;
import seedu.address.testutil.DayBuilder;



public class CalorieManagerTest {

    @Test
    void addTotalCalorieOut() {
        Day day = new DayBuilder().build();
        day.addTotalCalorieOut(CALORIE_COUNT);
        day.addTotalCalorieOut(CALORIE_COUNT);
        assertEquals(day.getTotalOutputCalorie(), 600);
    }

    @Test
    void getCalorieOutputList() {
        Day day = new DayBuilder().build();

        assertEquals(day.getCalorieOutputList(), new ArrayList<Output>());
        assertTrue(day.getCalorieOutputList().isEmpty());

        day.addCalorieOutput(OUTPUT);
        assertFalse(day.getCalorieOutputList().isEmpty());
    }

    @Test
    void addCalorieOutput() {
        Day day = new DayBuilder().build();
        day.addCalorieOutput(OUTPUT);
        day.addCalorieOutput(OUTPUT);
        assertEquals(day.getTotalOutputCalorie(), 600);
        assertFalse(day.getCalorieOutputList().isEmpty());
    }

    @Test
    void getTotalOutputCalorie() {
        Day day = new DayBuilder().build();
        day.addCalorieOutput(OUTPUT);
        day.addCalorieOutput(OUTPUT);
        assertEquals(day.getTotalOutputCalorie(), 600);
    }

    @Test
    void getCalorieInputList() {
        Day day = new DayBuilder().build();
        assertEquals(day.getCalorieInputList(), new ArrayList<Input>());
        assertTrue(day.getCalorieInputList().isEmpty());

        day.addCalorieInput(INPUT);
        assertFalse(day.getCalorieInputList().isEmpty());
    }

    @Test
    void addTotalCalorieInput() {
        Day day = new DayBuilder().build();
        day.addTotalCalorieInput(CALORIE_COUNT);
        day.addTotalCalorieInput(CALORIE_COUNT);
        assertEquals(day.getTotalInputCalorie(), 600);
    }

    @Test
    void addCalorieInput() {
        Day day = new DayBuilder().build();
        day.addCalorieInput(INPUT);
        day.addCalorieInput(INPUT);
        assertEquals(day.getTotalInputCalorie(), 600);
        assertFalse(day.getCalorieInputList().isEmpty());
    }
}
