package seedu.address.model.day.calorie;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;

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
}
