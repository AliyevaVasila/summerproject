
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainSceneController {
    @FXML
    private TextField txt_result;
    private Label result;
    String op = "";
    long number1 = 0;
    long number2 = 0;
    private boolean start = true;

    @FXML
    public void Number(ActionEvent ae) {
        if(start){
            result.setText("");
            start=false;
        }
        String no = ((Button)ae.getSource()).getText();
        txt_result.setText(txt_result.getText() + no);
    }

    @FXML
    public void Operation(ActionEvent ae) {
        String operation = ((Button) ae.getSource()).getText();
        if (!operation.equals("=")) {
            if (!operation.isEmpty()) {
                return;
            }
            op = operation;
            number1 = Long.parseLong(txt_result.getText());
            txt_result.setText("");
        } else {
            if (operation.isEmpty()) {
                return;
            }
            number2 = Long.parseLong(txt_result.getText());
           calculate(number1, number2, op);
            op = "";
        }

    }

    public void calculate(long n1, long n2, String op) {
        switch (op) {
            case "+":
                txt_result.setText(n1 + n2 + "");
                break;

            case "-":
                txt_result.setText(n1 - n2 + "");
                break;

            case "*":
                txt_result.setText(n1 * n2 + "");
                break;

            case "/":
                if (n2 == 0) {
                    txt_result.setText("error");
                    break;
                }
                txt_result.setText(n1 / n2 + "");
                break;

            case "AC":
                txt_result.setText("0");
                break;
        }
    }

}
