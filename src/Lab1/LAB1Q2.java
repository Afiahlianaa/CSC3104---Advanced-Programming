package Lab1;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LAB1Q2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Create GridPane
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        pane.setHgap(5);
        pane.setVgap(5);

        //Placing nodes in the pane
        pane.add(new Label("User ID:"), 0, 0);
        pane.add(new TextField(), 1, 0);
        pane.add(new Label("Name:"), 0, 1);
        pane.add(new TextField(), 1, 1);
        pane.add(new Label("Weight (kg):"), 0, 2);
        TextField txtWeight = new TextField();
        pane.add(txtWeight, 1, 2);
        pane.add(new Label("Height (m):"), 0, 3);
        TextField txtHeight = new TextField();
        pane.add(txtHeight, 1, 3);

        Button btCalc = new Button("Calculate");
        pane.add(btCalc,1,5);
        GridPane.setHalignment(btCalc, HPos.CENTER);

        //Label to display result
        Label result = new Label();
        pane.add(result, 1,7);
        GridPane.setHalignment(result, HPos.CENTER);

        //Action Button when "Calculate" Button is clicked
        btCalc.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(txtWeight.getText()); //use Double.parseDouble bcs textfield is in String
                double height = Double.parseDouble(txtHeight.getText());

                double bmi = weight/(height*height);
                result.setText("Your BMI is: " + String.format("%.2f", bmi));
            } catch (NumberFormatException ex) {
                result.setText("Please enter valid numbers for weight and height");
            }
        });

        //create the scene and place onto stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Body Mass Index (BMI) Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
