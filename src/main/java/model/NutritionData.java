package model;

import com.google.gson.annotations.SerializedName;

public class NutritionData {
    private String foodName;
    @SerializedName("nf_calories")
    private double calories;

    // Getters and setters
    public String getFoodName() { return foodName; }
    public void setFoodName(String foodName) { this.foodName = foodName; }

    public double getCalories() { return calories; }
    public void setCalories(double calories) { this.calories = calories; }
}
