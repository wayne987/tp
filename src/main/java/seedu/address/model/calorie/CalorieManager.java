package seedu.address.model.calorie;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.core.index.Index;

public class CalorieManager {

    private List<Input> calorieInputList;
    private List<Output> calorieOutputList;
    private int totalCalorieIn;
    private int totalCalorieOut;
    private final Logger logger = LogsCenter.getLogger(CalorieManager.class);

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

    /**
     * A method to update TotalCalorieOut
     * @param calorieOutput amount of calorie output to be updated
     */
    public void addTotalCalorieOut(CalorieCount calorieOutput) {
        int previousTotalCalorieOut = totalCalorieOut;
        totalCalorieOut += Integer.parseInt(calorieOutput.toString());
        logger.info("----------update total calorie output----------");
        logger.info(previousTotalCalorieOut + "+" + calorieOutput.toString() + "=" + totalCalorieOut);
    }

    /**
     * A method to update TotalCalorieIn
     * @param calorieInput amount of calorie Input to be updated
     */
    public void addTotalCalorieInput(CalorieCount calorieInput) {
        int previousTotalCalorieIn = totalCalorieIn;
        totalCalorieIn += Integer.parseInt(calorieInput.toString());
        logger.info("----------update total calorie Input----------");
        logger.info(previousTotalCalorieIn + "+" + calorieInput.toString() + "=" + totalCalorieIn);
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

    /**
     * removes a calorie from the List and update the total calorie input
     */
    public void removeCalorie(String type, Index targetIndex) {
        int index = targetIndex.getZeroBased();
        if (type.equals("in")) {
            deleteTotalCalorieInput(index);
            calorieInputList.remove(index);
        } else {
            deleteTotalCalorieOutput(index);
            calorieOutputList.remove(index);
        }
    }
    /**
     * Get size of list depending on type
     * @param type of calorie
     */
    public int getListSize(String type) {
        assert type.equals("in") | type.equals("out") : "type can only be in/out";

        if (type.equals("in")) {
            return calorieInputList.size();
        } else {
            return calorieOutputList.size();
        }
    }

    /**
     * Get a calorie of a certain type and index
     * @param type
     * @param index
     */
    public Calorie getCalorie(String type, Index index) {
        assert type.equals("in") | type.equals("out") : "type can only be in/out";
        if (type.equals("in")) {
            return calorieInputList.get(index.getZeroBased());
        } else {
            return calorieOutputList.get(index.getZeroBased());
        }
    }
}
