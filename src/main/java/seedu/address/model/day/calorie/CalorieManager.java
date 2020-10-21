package seedu.address.model.day.calorie;

import java.util.ArrayList;
import java.util.List;

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

    public List<Output> getCalorieOutputList() {
        return calorieOutputList;
    }

    public List<Input> getCalorieInputList() {
        return calorieInputList;
    }


    /**
     * add a calorie input into an already sorted calorieInputList and update the total calorie input
     */
    public void addCalorieInput(Input calorieInput) {
        boolean isAdded = false;
        for (int index = calorieInputList.size() - 1; index >= 0; index -= 1) {
            if (calorieInput.happenAfter(calorieInputList.get(index))) {
                calorieInputList.add(index + 1, calorieInput);
                isAdded = true;
                break;
            }
        }
        if (isAdded == false) {
            calorieInputList.add(0, calorieInput);
        }
        addTotalCalorieInput(calorieInput.getCalorieCount());
    }

    /**
     * add a calorie output into an already sorted calorieOutputList and update the total calorie output
     */
    public void addCalorieOutput(Output calorieOutput) {
        boolean isAdded = false;
        for (int index = calorieOutputList.size() - 1; index >= 0; index -= 1) {
            if (calorieOutput.happenAfter(calorieOutputList.get(index))) {
                calorieOutputList.add(index + 1, calorieOutput);
                isAdded = true;
                break;
            }
        }
        if (isAdded == false) {
            calorieOutputList.add(0, calorieOutput);
        }
        addTotalCalorieOut(calorieOutput.getCalorieCount());
    }
}
