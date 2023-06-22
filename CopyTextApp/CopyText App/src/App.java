import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application implements EventHandler<ActionEvent> {
    Button button;
    TextArea textField1 = new TextArea();
    TextArea textField2 = new TextArea();

    boolean copyToTextField2 = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        stage.setTitle("TextApp");

        VBox vbox1 = new VBox(10);
        vbox1.setPadding(new Insets(20));
        vbox1.setMinWidth(300);  
        vbox1.setStyle("-fx-background-color: #FBFAF0");  
        vbox1.getChildren().addAll(new Label("Text Field 1"), textField1);

        VBox vbox2 = new VBox(10);
        vbox2.setPadding(new Insets(20));
        vbox2.setMinWidth(300); 
        vbox2.setStyle("-fx-background-color: #FFE5D9");  
        vbox2.getChildren().addAll(new Label("Text Field 2"), textField2);

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(20));
        hbox.getChildren().addAll(vbox1, vbox2);

        button = new Button("\u276F");
        button.setOnAction(this);

        StackPane layout = new StackPane();
        layout.getChildren().addAll(hbox, button);

        Scene scene = new Scene(layout, 620, 550);
        stage.setScene(scene);

        stage.show();
    }

    @Override
    public void handle(ActionEvent e) {
        if (e.getSource() == button) {
            if (copyToTextField2) {
                button.setText("\u276E");
                String text = textField1.getText();
                textField2.setText(text);
                textField1.setText("");
            } else {
                button.setText("\u276F");
                String text = textField2.getText();
                textField1.setText(text);
                textField2.setText("");
            }

            copyToTextField2 = !copyToTextField2;
        }
    }
}
