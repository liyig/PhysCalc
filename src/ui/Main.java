package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import model.PhysInput;

import static java.sql.Types.NULL;

public class Main extends Application implements EventHandler<ActionEvent> {

    // Initialize storage as an "empty", static array
    private String[] storage = {"NULL", "NULL", "NULL"};
    public PhysInput physData;
    // Display user's input or current result of evaluation
    private Label textScreen = new Label("0");
    public Label message = new Label("Receiving input...");
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
    // Calculate button
    private Button buttonCalculate = new Button("Calculate");

    private Scene basicScene, physScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) throws Exception {
        // Layout of basicScene
        BorderPane basicPane = new BorderPane();
        basicPane.setTop(getBasicTop());
        basicPane.setCenter(getBasicCenter());
        basicPane.setLeft(getBasicSide());
        basicScene = new Scene(basicPane, 390, 250);

        // Button to basicScene
        buttonBasic.setOnAction(e -> primaryStage.setScene(basicScene));

        // Layout of physScene
        BorderPane physPane = new BorderPane();
        physPane.setLeft(getPhysSide());
        physPane.setCenter(getPhysCentre());
        physScene = new Scene(physPane, 600, 400);


        // Button to physScene
        buttonPhys.setOnAction(e -> primaryStage.setScene(physScene));

        primaryStage.setScene(physScene); //!!! temporary set to physScene for easy testing
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
    private GridPane getBasicCenter() {
        GridPane center = new GridPane();
        center.setHgap(20);
        center.setVgap(20);
        center.setPadding(new Insets(20));

        center.add(button7, 0, 0);
        center.add(button8, 1, 0);
        center.add(button9, 2, 0);
        center.add(buttonDivide, 3, 0);
        center.add(off, 4, 0);

        center.add(button4, 0, 1);
        center.add(button5, 1, 1);
        center.add(button6, 2, 1);
        center.add(buttonMultiply, 3, 1);
        center.add(backspace, 4, 1);

        center.add(button1, 0, 2);
        center.add(button2, 1, 2);
        center.add(button3, 2, 2);
        center.add(buttonMinus, 3, 2);
        center.add(buttonPower, 4, 2);

        center.add(button0, 0, 3);
        center.add(buttonDot, 1, 3);
        center.add(buttonEqual, 2, 3);
        center.add(buttonAdd, 3, 3);
        center.add(ac, 4, 3);

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

        return center;
    }

    /**
     * Sets up side og basicScene with button
     * @return VBox with buttons
     */
    private VBox getBasicSide() {
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);
        side.setPadding(new Insets(10));
        side.getChildren().add(buttonPhys);
        return side;
    }

    /**
     * Sets up side og physScene with button
     * @return VBox with buttons
     */
    private VBox getPhysSide() {
        VBox side = new VBox();
        side.setAlignment(Pos.CENTER);
        side.setPadding(new Insets(10));
        side.getChildren().add(buttonBasic);
        return side;

    }

    /**
     * Sets up the centre of physScene
     * @return GridPane
     */
    private GridPane getPhysCentre() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text instruction = new Text("Please enter your inputs \nHover over the button to see what inputs are needed");
        instruction.setFont(Font.font("Arial", FontWeight.NORMAL, 16));
        grid.add(instruction, 0, 0, 3, 1);

        Label u = new Label("Initial velocity (m/s): ");
        grid.add(u, 0, 1);
        TextField uTextField = new TextField();
        uTextField.setPromptText("Enter NA is no data");
        grid.add(uTextField, 1, 1);

        Label s = new Label("Displacement (m): ");
        grid.add(s, 0, 2);
        TextField sTextField = new TextField();
        sTextField.setPromptText("Enter NA is no data");
        grid.add(sTextField, 1, 2);

        Label a = new Label("Acceleration (m/s^2): ");
        grid.add(a, 0, 3);
        TextField aTextField = new TextField();
        aTextField.setPromptText("Enter NA is no data");
        grid.add(aTextField, 1, 3);

        Label t = new Label("Time taken (s): ");
        grid.add(t, 0, 4);
        TextField tTextField = new TextField();
        tTextField.setPromptText("Enter NA is no data");
        grid.add(tTextField, 1, 4);

        grid.add(buttonCalculate, 1, 5);
        grid.add(message, 1, 6);




         buttonCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (uTextField.getText().equals("") || sTextField.getText().equals("") || aTextField.getText().equals("") || tTextField.getText().equals("")) {
                    message.setText("Invalid input");
                }
                else message.setText(physData.calculate());
            }
        });
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
