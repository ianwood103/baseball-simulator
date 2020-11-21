import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainController {

    public Pane pane1;
    public Pane pane2;
    public Pane pane3;
    public Pane pane4;
    public Pane pane5;
    public Pane pane6;
    public Pane pane7;
    public Pane pane8;
    public Pane pane9;
    public AnchorPane ap;
    public Button button;

    public void pickLocation() throws Exception{
        int num = (int) (Math.random() * 9);

        if (num == 0) {
            pane1.styleProperty().set("-fx-background-color: black");
        } else if (num == 1) {
            pane2.styleProperty().set("-fx-background-color: black");
        } else if(num == 2) {
            pane3.styleProperty().set("-fx-background-color: black");
        } else if(num == 3) {
            pane4.styleProperty().set("-fx-background-color: black");
        } else if(num == 4) {
            pane5.styleProperty().set("-fx-background-color: black");
        } else if(num == 5) {
            pane6.styleProperty().set("-fx-background-color: black");
        } else if(num == 6) {
            pane7.styleProperty().set("-fx-background-color: black");
        } else if(num == 7) {
            pane8.styleProperty().set("-fx-background-color: black");
        } else if(num == 8) {
            pane9.styleProperty().set("-fx-background-color: black");
        } else {
            System.out.println("Out of bounds");
        }

        this.changeButton();
    }

    public void changeButton() {
        button.setOnAction(e -> {
            Stage window = (Stage) ap.getScene().getWindow();
            Parent root = null;

            try {
                root = FXMLLoader.load(getClass().getResource("Outcome.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            window.setScene(new Scene(root, window.getWidth(), window.getHeight()));
        });
        button.setText("Continue");
        button.styleProperty().set("-fx-background-color: green");
    }
}
