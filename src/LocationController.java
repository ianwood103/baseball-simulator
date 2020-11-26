import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

//Controller class for Location.fxml
public class LocationController {

    //Instantiates variables corresponding to node ids in Location.fxml
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

    //Instantiates controller as an OutcomeController class, which will be used to hold the controller for Outcome.fxml
    private OutcomeController controller;

    //Instantiates the Player object so that the player data can be passed to OutcomeController
    private Player player;

    //Picks a random square and sets its background to black to indicate where the pitch is being thrown
    //This is called when the button is clicked
    public void pickLocation() {

        //Creates a random number from 0 to 9
        int num = (int) (Math.random() * 9);

        //A random square is set to black using this random number
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

        //Calls changeButton method once the pitch location has been picked
        this.changeButton();
    }

    //Method that changes the Pick Location button into a button that continues onto the Outcome.fxml screen
    public void changeButton() {

        //Sets the new action of the button to be changing the scene to the one held in Outcome.fxml
        button.setOnAction(e -> {
            //Gets stage from the AnchorPane node in Location.fxml
            Stage window = (Stage) ap.getScene().getWindow();
            Parent root = null;

            //Safely loads Outcome.fxml and passes player data into it
            try {

                //Loads Outcome.fxml into the program
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Outcome.fxml"));
                root = loader.load();

                //Passes the player data into the controller
                controller = loader.getController();
                controller.updateStats(player);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            //Sets the new scene of the window to be the one held in Outcome.fxml
            window.setScene(new Scene(root));
        });

        //Changes the styling of the button to a green button that says Continue
        button.setText("Continue");
        button.styleProperty().set("-fx-background-color: green");
    }

    //Method used to accept the player data from Main class
    public void updateStats(Player player) {
        this.player = player;
    }
}
