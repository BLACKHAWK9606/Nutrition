package controller;

import model.NutritionData;

public class Gson {
    private String string;
    private Class<NutritionData> nutritionDataClass;

    public NutritionData fromJson(String string, Class<NutritionData> nutritionDataClass) {
        this.string = string;
        this.nutritionDataClass = nutritionDataClass;
        return null;
    }

    public String getString() {
        return string;
    }

}
