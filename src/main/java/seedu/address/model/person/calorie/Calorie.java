package seedu.address.model.person.calorie;

public class Calorie {
    // Identity fields
    private CalorieCount calorieCount;
    private Time time;

    public CalorieCount getCalorieCount(){
        return calorieCount;
    }

    public Time getTime(){
        return time;
    }

    public Calorie(CalorieCount calorieCount, Time time){
        this.calorieCount = calorieCount;
        this.time = time;
    }

}
