package seedu.address.model.day.calorie;

public class Output extends Calorie {

    private Exercise exercise;
    /**
     * Every field must be present and not null.
     */
    public Output(Time time, Exercise exercise, CalorieCount calorieCount) {
        super(calorieCount, time);
        this.exercise = exercise;
    }

    public Exercise getExercise() {
        return exercise;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(" Exercise: ")
                .append(getExercise())
                .append(" Time: ")
                .append(getTime())
                .append(" Calorie Burnt: ")
                .append(getCalorieCount());

        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Output(new Time("13:00"), new Exercise("running"), new CalorieCount("100")));
    }
}
