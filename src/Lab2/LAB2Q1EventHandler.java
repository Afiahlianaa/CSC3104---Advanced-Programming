package Lab2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LAB2Q1EventHandler extends Application {

    double bmi; //declare as class-variable to access through different methods

    @Override
    public void start(Stage primaryStage) {
        //Create GridPane
        GridPane pane = new GridPane(); //create gridpane
        pane.setAlignment(Pos.CENTER); //center the component in the center of the stage
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
        GridPane.setHalignment(btCalc, HPos.CENTER); //set the node in the gridpane in center

        //Label to display result
        Label result = new Label();
        pane.add(result, 1,7);
        GridPane.setHalignment(result, HPos.CENTER);

        //Label to display classification and risk
        Label classRisk = new Label();
        pane.add(classRisk, 1, 8);
        GridPane.setHalignment(classRisk, HPos.CENTER);

        //Action Button when "Calculate" Button is clicked
        btCalc.setOnAction(e -> {
            try {
                double weight = Double.parseDouble(txtWeight.getText()); //use Double.parseDouble bcs textfield is in String
                double height = Double.parseDouble(txtHeight.getText());

                bmi = weight/(height*height);
                result.setText("Your BMI is: " + String.format("%.2f", bmi));

                Classification classification = new Classification();
                classification.handle(new ActionEvent()); //trigger actionEvent
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

    class Classification implements EventHandler<ActionEvent> {
        @Override
        public void handle (ActionEvent e) {
            String classification, risk;

            if (bmi<18.5) {
                classification = "Underweight";
                risk = "Increase";
            }
            else if (bmi>=18.5 && bmi<25) {
                classification = "Normal Weight";
                risk = "Least";
            }
            else if (bmi>=25 && bmi<30) {
                classification = "Overweight";
                risk = "Increased";
            }
            else if (bmi>=30 && bmi<35) {
                classification = "Obese I";
                risk = "High";
            }
            else if (bmi>=35 && bmi<40) {
                classification = "Obese II";
                risk = "Very high";
            }
            else {
                classification = "Obese III";
                risk = "Extremely high";
            }

            //Display text
            System.out.println("Classification: " + classification + "\n" + risk + " risk of developing health problems");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}