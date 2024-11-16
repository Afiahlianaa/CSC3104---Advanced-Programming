package Lab1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.Random;

public class LAB1Q1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Create a gridpane
        GridPane pane = new GridPane();
        Random random = new Random();
        for (int row=0; row<10; row++) {
            for (int col=0; col<8; col++) {
                TextField textField = new TextField();
                int randomNum = random.nextInt(9) + 2; //generate random number between 2-10
                textField.setText(String.valueOf(randomNum)); //use String.valueOf to convert int into String
                //to align the text inside gridpane to the center
                textField.setAlignment(Pos.CENTER); //alternatively can use javafx.geometry.CENTER (does not need to import at above)
                textField.setEditable(false); //to set the text into non-editable
                textField.setPrefSize(50, 50); //set the size of the textfield
                //add textfield into the gridpane
                pane.add(textField, col, row);
            }
        }
        Scene scene = new Scene(pane, 400, 500);
        primaryStage.setTitle("Lab 1 Assignment");
        primaryStage.setScene(scene);
        primaryStage.show(); //display the stage
    }
}