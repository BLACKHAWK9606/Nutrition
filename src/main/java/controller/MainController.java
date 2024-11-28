package controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import model.NutritionData;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MainController {
    @FXML private TextField foodInput;
    @FXML private Label resultLabel;

    @FXML
    private void handleSearch() throws IOException {
        String food = foodInput.getText();
        String apiKey = "2b0507002a963936f791538015cec322";
        String appId = "44ca3931";
        String apiUrl = "https://api.nutritionix.com/v1_1/search/" + food + "?results=0:1&fields=item_name,nf_calories&appId=" + appId + "&appKey=" + apiKey;

        HttpURLConnection connection = (HttpURLConnection) new URL(apiUrl).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        Scanner scanner = new Scanner(connection.getInputStream());
        StringBuilder jsonResponse = new StringBuilder();
        while (scanner.hasNext()) {
            jsonResponse.append(scanner.nextLine());
        }

        NutritionData data = new controller.Gson().fromJson(jsonResponse.toString(), NutritionData.class);
        resultLabel.setText("Calories: " + data.getCalories());
    }
}
