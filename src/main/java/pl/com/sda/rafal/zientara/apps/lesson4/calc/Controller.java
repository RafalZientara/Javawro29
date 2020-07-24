package pl.com.sda.rafal.zientara.apps.lesson4.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.MathContext;


public class Controller {

    @FXML
    private TextField screenInput;

    private Operation operation = Operation.PLUS;
    private BigDecimal firstNumber;
    private boolean shouldClear = false;

    @FXML
    public void handlerNumberPressed(ActionEvent actionEvent) {
        if (shouldClear) {
            shouldClear = false;
            screenInput.clear();
        }
        Object object = actionEvent.getSource();


//        if (object.getClass().equals(Button.class)) {
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

    private BigDecimal getNumberFromScreen() {
        try {
            String text = screenInput.getText();
            String normalized = text.replace(",", ".");
            return new BigDecimal(normalized);
        } catch (Exception e) {
            //todo wyswietl blad!
            e.printStackTrace();
            return BigDecimal.ONE;
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
        BigDecimal a = firstNumber;
        BigDecimal b = getNumberFromScreen();
        BigDecimal output = calcOperation(a, b);
        screenInput.setText(String.valueOf(output));
        shouldClear = true;
    }

    private BigDecimal calcOperation(BigDecimal a, BigDecimal b) {
        switch (operation) {
            case PLUS:
                return a.add(b);
            case MINUS:
                return a.subtract(b);
            case MULTIPLY:
                return a.multiply(b);
            case DIVIDE:
                return a.divide(b, MathContext.DECIMAL128);
        }
        throw new IllegalStateException("Unsupported operation " + operation);
    }
}
