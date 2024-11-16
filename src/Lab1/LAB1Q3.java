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

public class LAB1Q3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Create GridPane, set alignment, gap from stage sides and gap between
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setAlignment(Pos.CENTER); //all component will be set in the center of the stage
        pane.setHgap(5); //horizontal gap between gridpane
        pane.setVgap(5); //vertical gap between gridpane

        pane.add(new Label("Unit Price: RM"),0,0);
        //instead of pane.add, this was used to help on the calculation later bcs it will be referred
        TextField txtPrice = new TextField();
        pane.add(txtPrice, 1, 0);
        pane.add(new Label("Quantity:"), 0,1);
        TextField txtQuantity = new TextField();
        pane.add(txtQuantity,1,1);
        //label for total sale
        pane.add(new Label("Total Sale: RM"),0,3);

        //Create Button for calculation
        Button btCalc = new Button("Calculate");
        pane.add(btCalc,1,2);
        GridPane.setHalignment(btCalc, HPos.CENTER);

        //create label for total price
        Label totalPrice = new Label();
        pane.add(totalPrice,1,3);
        GridPane.setHalignment(totalPrice, HPos.LEFT);  //text in gridpane set to the left

        //action button when btCalc is clicked
        btCalc.setOnAction (e -> {
            double price = Double.parseDouble(txtPrice.getText()); //use double.parseDouble bcs textfield read in String
            double qty = Integer.parseInt(txtQuantity.getText());

            double total = price * qty;
            totalPrice.setText(String.format("%.2f", total)); //set the label total price with the result of the calculation
        });

        //create scene and put onto stage
        Scene scene = new Scene(pane, 300,150); //set the size for the scene (default value will fit the content)
        primaryStage.setTitle("Total Sale");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}