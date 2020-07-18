package pl.com.sda.rafal.zientara.apps.lesson4.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField screenInput;

    private Operation operation = Operation.PLUS;
    private double firstNumber;
    //todo zamien na BigDecimal
    private boolean shouldClear = false;

    @FXML
    public void handlerNumberPressed(ActionEvent actionEvent) {
        if (shouldClear) {
            shouldClear = !shouldClear;
            screenInput.clear();
        }
        Object object = actionEvent.getSource();
        if (object instanceof Button) {
            Button button = (Button) object;
            String text = button.getText();
            System.out.println(text);
            screenInput.appendText(text);
        }
    }

    @FXML
    public void handlerPlusPressed(ActionEvent actionEvent) {
        operation = Operation.PLUS;
        getFirstNumberAndClear();
    }

    private void getFirstNumberAndClear() {
        firstNumber = getNumberFromScreen();
        shouldClear = true;
    }

    private double getNumberFromScreen() {
        try {
            String text = screenInput.getText();
            String normalized = text.replace(",", ".");
            return Double.parseDouble(normalized);
        } catch (Exception e) {
            //todo wyswietl blad!
            e.printStackTrace();
            return 1;
        }
    }

    @FXML
    public void handlerMinusPressed(ActionEvent actionEvent) {
        operation = Operation.MINUS;
        getFirstNumberAndClear();
    }

    @FXML
    public void handlerMultiplyPressed(ActionEvent actionEvent) {
        operation = Operation.MULTIPLY;
        getFirstNumberAndClear();
    }

    @FXML
    public void handlerDividePressed(ActionEvent actionEvent) {
        operation = Operation.DIVIDE;
        getFirstNumberAndClear();
    }

    @FXML
    public void handlerEqualPressed(ActionEvent actionEvent) {
        double a = firstNumber;
        double b = getNumberFromScreen();
        double output = calcOperation(a, b);
        screenInput.setText(String.valueOf(output));
        shouldClear = true;
    }

    private double calcOperation(double a, double b) {
        switch (operation) {
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
        }
        throw new IllegalStateException("Unsupported operation " + operation);
    }
}
