package seedu.address.model.day.calorie;

import java.util.ArrayList;
import java.util.List;

import seedu.address.commons.core.index.Index;

public class CalorieManager {

    private List<Input> calorieInputList;
    private List<Output> calorieOutputList;
    private int totalCalorieIn;
    private int totalCalorieOut;

    /**
     * Constructor for Manager that manage calorie input/output
     */
    public CalorieManager() {
        this.calorieOutputList = new ArrayList<>();
        this.calorieInputList = new ArrayList<>();
    }

    /**
     * Constructor for Manager that manage calorie input/output
     */
    public CalorieManager(List<Input> inputList, List<Output> outputList) {
        this.calorieInputList = inputList;
        this.calorieOutputList = outputList;
        updateTotalCalorieCounts(inputList, outputList);
    }

    /**
     * returns the total input calorie
     */
    public int getTotalInputCalorie() {
        return totalCalorieIn;
    }

    /**
     * returns the total input calorie
     */
    public int getTotalOutputCalorie() {
        return totalCalorieOut;
    }

    /**
     * A method to update all the counters
     * @param inputList list of inputs
     * @param outputList list of outputs
     */
    public void updateTotalCalorieCounts(List<Input> inputList, List<Output> outputList) {
        for (Input x: inputList) {
            totalCalorieIn += Integer.parseInt(x.getCalorieCount().calorieCount);
        }
        for (Output y: outputList) {
            totalCalorieOut += Integer.parseInt(y.getCalorieCount().calorieCount);
        }
    }

    public void addTotalCalorieOut(CalorieCount calorieCount) {
        totalCalorieOut += Integer.parseInt(calorieCount.toString());
    }

    public void addTotalCalorieInput(CalorieCount calorieInput) {
        totalCalorieIn += Integer.parseInt(calorieInput.toString());
    }

    /**
     * delete calorie output from the calorieOutputList and update the total calorie output.
     */
    public void deleteTotalCalorieOutput(int index) {
        CalorieCount calorieCount = getCalorieOutputList().get(index).getCalorieCount();
        totalCalorieOut -= Integer.parseInt(calorieCount.toString());
    }

    /**
     * delete calorie input from the calorieInputList and update the total calorie input.
     */
    public void deleteTotalCalorieInput(int index) {
        CalorieCount calorieCount = getCalorieInputList().get(index).getCalorieCount();
        totalCalorieIn -= Integer.parseInt(calorieCount.toString());
    }

    public List<Output> getCalorieOutputList() {
        return calorieOutputList;
    }

    public List<Input> getCalorieInputList() {
        return calorieInputList;
    }


    /**
     * add a calorie input into the calorieInputList and update the total calorie input
     */
    public void addCalorieInput(Input calorieInput) {
        calorieInputList.add(calorieInput);
        addTotalCalorieInput(calorieInput.getCalorieCount());
    }

    /**
     * add a calorie output into the calorieOutputList and update the total calorie output
     */
    public void addCalorieOutput(Output calorieOutput) {
        calorieOutputList.add(calorieOutput);
        addTotalCalorieOut(calorieOutput.getCalorieCount());
    }

    /**
     * removes a calorie input from the calorieInputList and update the total calorie input
     */
    public void removeCalorieInput(Index targetIndex) {
        int index = targetIndex.getZeroBased();
        deleteTotalCalorieInput(index);
        calorieInputList.remove(index);
    }

    /**
     * removes a calorie output from the calorieOutputList and update the total calorie Output
     */
    public void removeCalorieOutput(Index targetIndex) {
        int index = targetIndex.getZeroBased();
        deleteTotalCalorieOutput(index);
        calorieOutputList.remove(index);
    }
}
