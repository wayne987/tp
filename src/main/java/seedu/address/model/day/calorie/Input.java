package seedu.address.model.day.calorie;

public class Input extends Calorie {

    private Food food;

    /**
     * Every field must be present and not null.
     */
    public Input(Time time, Food food, CalorieCount calorieCount) {
        super(calorieCount, time);
        this.food = food;
    }

    public Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Food: ")
                .append(getFood())
                .append(" Time: ")
                .append(getTime())
                .append(" Calorie Intake: ")
                .append(getCalorieCount());

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Input(new Time("18:00"), new Food("Laksa"), new CalorieCount("400")));
    }
}
