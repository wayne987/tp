package seedu.address.model.day.calorie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalCalories.INPUT_A;
import static seedu.address.testutil.TypicalCalories.INPUT_B;
import static seedu.address.testutil.TypicalCalories.INPUT_C;
import static seedu.address.testutil.TypicalCalories.OUTPUT_A;
import static seedu.address.testutil.TypicalCalories.OUTPUT_B;
import static seedu.address.testutil.TypicalCalories.OUTPUT_C;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.TypicalCalories;




public class CalorieManagerTest {

    @Test
    void addTotalCalorieOutput() {
        CalorieManager calorieManager = new CalorieManager();
        calorieManager.addTotalCalorieOut(OUTPUT_A.getCalorieCount());
        calorieManager.addTotalCalorieOut(OUTPUT_B.getCalorieCount());
        calorieManager.addTotalCalorieOut(OUTPUT_C.getCalorieCount());
        assertEquals(666, calorieManager.getTotalOutputCalorie());
    }

    @Test
    void addTotalCalorieInput() {
        CalorieManager calorieManager = new CalorieManager();
        calorieManager.addTotalCalorieInput(INPUT_A.getCalorieCount());
        calorieManager.addTotalCalorieInput(INPUT_B.getCalorieCount());
        calorieManager.addTotalCalorieInput(INPUT_C.getCalorieCount());
        assertEquals(603, calorieManager.getTotalInputCalorie());
    }

    @Test
    void getCalorieInputList() {
        CalorieManager calorieManager = new CalorieManager();

        assertEquals(calorieManager.getCalorieInputList(), new ArrayList<Input>());
        assertTrue(calorieManager.getCalorieInputList().isEmpty());

        calorieManager.addCalorieInput(INPUT_A);
        calorieManager.addCalorieInput(INPUT_B);
        calorieManager.addCalorieInput(INPUT_C);
        assertEquals(TypicalCalories.getTypicalInputList(), calorieManager.getCalorieInputList());
    }

    @Test
    void getCalorieOutputList() {
        CalorieManager calorieManager = new CalorieManager();

        assertEquals(calorieManager.getCalorieOutputList(), new ArrayList<Output>());
        assertTrue(calorieManager.getCalorieOutputList().isEmpty());

        calorieManager.addCalorieOutput(OUTPUT_A);
        calorieManager.addCalorieOutput(OUTPUT_B);
        calorieManager.addCalorieOutput(OUTPUT_C);
        assertEquals(calorieManager.getCalorieOutputList(), TypicalCalories.getTypicalOutputList());
    }

    @Test
    void getTotalInputCalorie() {
        CalorieManager calorieManager = new CalorieManager();
        calorieManager.addCalorieInput(INPUT_A);
        calorieManager.addCalorieInput(INPUT_B);
        calorieManager.addCalorieInput(INPUT_C);

        assertEquals(calorieManager.getTotalInputCalorie(), 603);
    }

    @Test
    void getTotalOutputCalorie() {
        CalorieManager calorieManager = new CalorieManager();
        calorieManager.addCalorieOutput(OUTPUT_A);
        calorieManager.addCalorieOutput(OUTPUT_B);
        calorieManager.addCalorieOutput(OUTPUT_C);

        assertEquals(calorieManager.getTotalOutputCalorie(), 666);
    }

    @Test
    void updateTotalCalorieCounts() {
        CalorieManager calorieManager = new CalorieManager();
        calorieManager.updateTotalCalorieCounts(TypicalCalories.getTypicalInputList(),
                                                TypicalCalories.getTypicalOutputList());
        assertEquals(calorieManager.getTotalInputCalorie(), 603);
        assertEquals(calorieManager.getTotalOutputCalorie(), 666);
    }
}
