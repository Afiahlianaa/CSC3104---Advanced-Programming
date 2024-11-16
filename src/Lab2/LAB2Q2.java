package Lab2;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LAB2Q2 extends Application {

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

        pane.add(new Label("Product Code: "), 0,0);
        TextField txtCode = new TextField();
        pane.add(txtCode, 1, 0);
        pane.add(new Label("Product Name:"), 0, 1);
        TextField txtName = new TextField();
        pane.add(txtName,1,1);
        pane.add(new Label("Unit Price: RM"),0,2);
        //instead of pane.add, this was used to help on the calculation later bcs it will be referred
        TextField txtPrice = new TextField();
        pane.add(txtPrice, 1, 2);
        pane.add(new Label("Quantity:"), 0,3);
        TextField txtQuantity = new TextField();
        pane.add(txtQuantity,1,3);
        //label for total sale
        pane.add(new Label("Product Code: "),0,7);
        pane.add(new Label("Product Name: "),0,8);
        pane.add(new Label("Price per unit: RM"),0,9);
        pane.add(new Label("Quantity: "),0,10);
        pane.add(new Label("Total Price: RM"),0,11);
        pane.add(new Label("Discount given: RM"),0,12);
        pane.add(new Label("Total Price Discount: RM"),0,13);

        //Create Button for calculation
        Button btCalc = new Button("Calculate");
        pane.add(btCalc,1,5);
        GridPane.setHalignment(btCalc, HPos.CENTER);

        //label for code
        Label code = new Label();
        pane.add(code,1,7);
        GridPane.setHalignment(code, HPos.LEFT);

        //label for product name
        Label name = new Label();
        pane.add(name,1,8);
        GridPane.setHalignment(name, HPos.LEFT);

        //label for price
        Label unitprice = new Label();
        pane.add(unitprice,1,9);
        GridPane.setHalignment(unitprice, HPos.LEFT);

        //label for quantity
        Label quantity = new Label();
        pane.add(quantity,1,10);
        GridPane.setHalignment(quantity, HPos.LEFT);

        //create label for total price
        Label totalPrice = new Label();
        pane.add(totalPrice,1,11);
        GridPane.setHalignment(totalPrice, HPos.LEFT); //text in gridpane set to the left

        //label for discount
        Label dscnt = new Label();
        pane.add(dscnt,1,12);
        GridPane.setHalignment(dscnt, HPos.LEFT); //text in gridpane set to the left

        //label for total after discount
        Label totalDscnt = new Label();
        pane.add(totalDscnt,1,13);
        GridPane.setHalignment(totalDscnt, HPos.LEFT); //text in gridpane set to the left

        //action button when btCalc is clicked
        //lambda event
        btCalc.setOnAction (e -> {
            try {
                double price = Double.parseDouble(txtPrice.getText()); //use double.parseDouble bcs textfield read in String
                double qty = Integer.parseInt(txtQuantity.getText());

                double total = price * qty;
                totalPrice.setText(String.format("%.2f", total)); //set the label total price with the result of the calculation

                //set textfield to the user input
                name.setText(txtName.getText());
                code.setText(txtCode.getText());
                unitprice.setText(txtPrice.getText());
                quantity.setText(txtQuantity.getText());

                //discount price
                double priceDiscount, totalDiscount;
                String discount;

                if (total <= 500) {
                    priceDiscount = 0.03 * total;
                    discount = "3%";
                    totalDiscount = 0.97 * total;
                } else if (total <= 5000) {
                    priceDiscount = 0.075 * total;
                    discount = "7.5%";
                    totalDiscount = 0.925 * total;
                } else if (total <= 10000) {
                    priceDiscount = 0.1 * total;
                    discount = "10%";
                    totalDiscount = 0.9 * total;
                } else {
                    priceDiscount = 0.15 * total;
                    discount = "15%";
                    totalDiscount = 0.85 * total;
                }

                //set label for discount and total price after discount
                dscnt.setText(discount + " = RM" + priceDiscount);
                totalDscnt.setText(String.valueOf(totalDiscount)); //need to wrap because setText only accept String value
            } catch (NumberFormatException ex) {
                // Create a new stage for the error message
                Stage errorStage = new Stage();
                errorStage.setTitle("Invalid Input");

                // Create a label for error message
                Label errorLabel = new Label("Please enter valid numbers for price and quantity.");
                Button okButton = new Button("OK");

                // Action for the OK button
                okButton.setOnAction(event -> errorStage.close());

                VBox errorPane = new VBox(10); // VBox with 10px spacing between elements
                errorPane.setPadding(new Insets(20));
                errorPane.setAlignment(Pos.CENTER);  // Center both the label and the button
                errorPane.getChildren().addAll(errorLabel, okButton);

                // Set scene and show error stage
                Scene errorScene = new Scene(errorPane, 350, 150);
                errorStage.setScene(errorScene);
                errorStage.show();
            }
        });

        //create scene and put onto stage
        Scene scene = new Scene(pane, 500,500); //set the size for the scene (default value will fit the content)
        primaryStage.setTitle("Total Sale");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}