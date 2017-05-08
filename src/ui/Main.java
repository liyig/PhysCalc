package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class Main extends Application implements EventHandler<ActionEvent> {

    // Initialize storage as an "empty", static array
    String[] storage = {"NULL", "NULL", "NULL"};
    // Display user's input or current result of evaluation
    private Label textScreen = new Label("0");
    // switch buttons
    Button buttonBasic = new Button("Basic Calculator");
    Button buttonPhys = new Button("Physics Calculator");
    // 0-9 buttons
    private Button button0 = new Button("0");
    private Button button1 = new Button("1");
    private Button button2 = new Button("2");
    private Button button3 = new Button("3");
    private Button button4 = new Button("4");
    private Button button5 = new Button("5");
    private Button button6 = new Button("6");
    private Button button7 = new Button("7");
    private Button button8 = new Button("8");
    private Button button9 = new Button("9");
    // Basic calculator buttons
    private Button buttonDot = new Button(".");
    private Button buttonEqual = new Button("=");
    private Button buttonAdd = new Button("+");
    private Button buttonMinus = new Button("-");
    private Button buttonMultiply = new Button("*");
    private Button buttonDivide = new Button("/");
    private Button ac = new Button("AC");
    private Button buttonPower = new Button("^");
    private Button backspace = new Button("←");
    private Button off = new Button("OFF");

    private Scene basicScene, physScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // Layout of basicScene
        BorderPane basicPane = new BorderPane();
        basicPane.setTop(getBasicTop());
        basicPane.setCenter(getBasicBottom());
        basicPane.setLeft(getBasicSide());
        basicScene = new Scene(basicPane, 390, 250);

        // Button to basicScene
        buttonBasic.setOnAction(e -> primaryStage.setScene(basicScene));

        // Layout of physScene
        BorderPane physPane = new BorderPane();
        physPane.setLeft(getPhysSide());
        physScene = new Scene(physPane, 400, 400);


        // Button to physScene
        buttonPhys.setOnAction(e -> primaryStage.setScene(physScene));

        primaryStage.setScene(basicScene);
        primaryStage.setTitle("Physics Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    /**
     * Sets up the textScreen
     * @return HBox with textScreen
     */
    private HBox getBasicTop() {
        HBox top = new HBox();
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(10, 10, 10, 10));
        top.getChildren().add(textScreen);
        textScreen.setFont(Font.font("Arial", 16));
        return top;
    }

    /**
     * Sets up the buttons and their functionalities
     * @return GridPane with buttons
     */
    private GridPane getBasicBottom() {
        GridPane bottom = new GridPane();
        bottom.setHgap(20);
        bottom.setVgap(20);
        bottom.setPadding(new Insets(20));

        bottom.add(button7, 0, 0);
        bottom.add(button8, 1, 0);
        bottom.add(button9, 2, 0);
        bottom.add(buttonDivide, 3, 0);
        bottom.add(off, 4, 0);

        bottom.add(button4, 0, 1);
        bottom.add(button5, 1, 1);
        bottom.add(button6, 2, 1);
        bottom.add(buttonMultiply, 3, 1);
        bottom.add(backspace, 4, 1);

        bottom.add(button1, 0, 2);
        bottom.add(button2, 1, 2);
        bottom.add(button3, 2, 2);
        bottom.add(buttonMinus, 3, 2);
        bottom.add(buttonPower, 4, 2);

        bottom.add(button0, 0, 3);
        bottom.add(buttonDot, 1, 3);
        bottom.add(buttonEqual, 2, 3);
        bottom.add(buttonAdd, 3, 3);
        bottom.add(ac, 4, 3);

        button0.setOnAction(this);
        button1.setOnAction(this);
        button2.setOnAction(this);
        button3.setOnAction(this);
        button4.setOnAction(this);
        button5.setOnAction(this);
        button6.setOnAction(this);
        button7.setOnAction(this);
        button8.setOnAction(this);
        button9.setOnAction(this);
        buttonDot.setOnAction(this);
        buttonEqual.setOnAction(this);
        buttonAdd.setOnAction(this);
        buttonMinus.setOnAction(this);
        buttonMultiply.setOnAction(this);
        buttonDivide.setOnAction(this);
        ac.setOnAction(this);
        buttonPower.setOnAction(this);
        backspace.setOnAction(this);
        off.setOnAction(this);

        return bottom;
    }

    /**
     * Sets up scene switching buttons
     * @return VBox with buttons
     */
    private VBox getBasicSide() {
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);
        side.setPadding(new Insets(10));
        side.getChildren().add(buttonPhys);
        return side;
    }

    private VBox getPhysSide() {
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);
        side.setPadding(new Insets(10));
        side.getChildren().add(buttonBasic);
        return side;

    }

    private GridPane getPhysBottom() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        return grid;
    }

    /**
     * Handles all buttons
     * Simple handlers do not have separated methods
     * @param e
     */
    @Override
    public void handle(ActionEvent e) {

        if (e.getSource() == off) {
            // Exit application
            Stage stage = (Stage) off.getScene().getWindow();
            stage.close();
        }

        if (e.getSource() == buttonDot) {
            handleDot();
            return;
        }


        if (e.getSource() == buttonEqual) {
            // updates the textScreen and storage if storage is full
            // separated from the other operators because equal sign is not added to storage
            if (storageIsFull()){
                calculate();
                return;
            }
            else return;
        }

        if (e.getSource() == backspace) {
            handleBackspace();
            return;
        }
        if (e.getSource() == ac) {
            // reset textScreen and storage
            textScreen.setText("0");
            clearStorage();
            return;
        }

        if (e.getSource() == buttonAdd || e.getSource() == buttonMinus || e.getSource() == buttonMultiply || e.getSource() == buttonDivide || e.getSource() == buttonPower) {
            if (storageIsFull()) {
                calculate();
            }
            storage[1] = ((Button) e.getSource()).getText();
            return;
        }

        else {
            String newDigit = ((Button) e.getSource()).getText();
            handleDigitEntered(newDigit);

        }
    }

    /**
     * Update the (full) storage by clearing it's current entry and storing the result of evaluation in storage[0]
     * textScreen displays value stored in storage[0]
     */
    private void calculate() {
        String result;
        double operand1 = Double.parseDouble(storage[0]);
        double operand2 = Double.parseDouble(storage[2]);
        String operator = storage[1];
        if (operator == "+") {
            clearStorage();
            result = Double.toString(operand1 + operand2);
            storage[0] = result;
        }
        if (operator == "-") {
            clearStorage();
            result = Double.toString(operand1 - operand2);
            storage[0] = result;
        }
        if (operator == "*") {
            clearStorage();
            result = Double.toString(operand1 * operand2);
            storage[0] = result;
        }
        if (operator == "/") {
            clearStorage();
            result = Double.toString(operand1 / operand2);
            storage[0] = result;
        }
        if (operator == "^") {
            clearStorage();
            result = Double.toString(Math.pow(operand1, operand2));
            storage[0] = result;
        }

        textScreen.setText(storage[0]);
    }


    /**
     * Check if storage is "empty", i.e. all entries are "NULL"
     * @return boolean
     */
    private boolean storageIsEmpty() {
        String s0 = storage[0];
        String s1 = storage[1];
        String s2 = storage[2];
        return s0.equals("NULL") && s1.equals("NULL") && s2.equals("NULL");
    }

    /**
     * Check if storage is full, i.e. no "NULL" entry
     * @return boolean
     */
    private boolean storageIsFull() {
        String s0 = storage[0];
        String s1 = storage[1];
        String s2 = storage[2];
        return !s0.equals("NULL") && !s1.equals("NULL") && !s2.equals("NULL");
    }

    /**
     * "Emptying" storage by setting all entries to "NULL"
     */
    private void clearStorage() {
        storage[0] = "NULL";
        storage[1] = "NULL";
        storage[2] = "NULL";
    }

    /**
     * Update storage and textScreen
     * If textScreen is displaying "0", it will be overwritten by the digits clicked
     * @param newDigit
     */
    private void handleDigitEntered(String newDigit) {
        if (storageIsEmpty()) {
            if (newDigit.equals("0")) return;
            storage[0] = newDigit;
            textScreen.setText(newDigit);
            return;
        }

        if (storageIsFull()) {
            String prevNum = storage[2];
            String newNum = prevNum + newDigit;
            storage[2] = newNum;
            textScreen.setText(newNum);
            return;
        }
        if (storage[1].equals("NULL") && storage[2].equals("NULL")) {
            String prevNum = storage[0];
            String newNum = prevNum + newDigit;
            storage[0] = newNum;
            textScreen.setText(newNum);
            return;
        }
        else {
            storage[2] = newDigit;
            textScreen.setText(newDigit);
            return;
        }
    }

    /**
     * Update storage and textScreen when backspace button is clicked
     * When last character on textScreen is backspaced, 0 is displayed
     * When an operator is backspaced, text cursor returns to the end of operand 1,
     * i.e. able to continue adding digits to operand1
     */
    private void handleBackspace() {
        if (textScreen.getText() == "0" || storageIsEmpty()) return;
        if (storageIsFull()) {
            int len = storage[2].length();
            if (len == 1){
                textScreen.setText("0");
                storage[2] = "NULL";
            }
            else {
                String newNum = textScreen.getText().substring(0, len-1);
                storage[2] = newNum;
                textScreen.setText(newNum);
            }
            return;
        }
        if (storage[1].equals("NULL") && storage[2].equals("NULL")) {
            int len = storage[0].length();
            if (len == 1) {
                storage[0] = "NULL";
                textScreen.setText("0");
            }
            else {
                String newNum = textScreen.getText().substring(0, len-1);
                storage[0] = newNum;
                textScreen.setText(newNum);
            }
            return;
        }
        else {
            storage[1] = "NULL";
            return;
        }
    }

    /**
     * Update storage and textScreen if textScreen does not contain "."
     */
    private void handleDot() {
        if (!textScreen.getText().contains(".")) {
            if (storageIsFull()) {
                storage[2] = storage[2] + ".";
            }
            else {
                storage[0] = storage[0] + ".";
            }
            textScreen.setText(textScreen.getText() + ".");
        }
    }
}
