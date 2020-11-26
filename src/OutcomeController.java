import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

//Controller class for Outcome.fxml
public class OutcomeController {

    //Instantiates variables corresponding to node ids in Outcome.fxml
    public RadioButton singleButton;
    public RadioButton doubleButton;
    public RadioButton tripleButton;
    public RadioButton homeRunButton;
    public RadioButton walkButton;
    public RadioButton outButton;
    public AnchorPane ap;

    //Instantiates player object so that controller can receive and store data from MainController
    private Player player;

    //Run automatically when Outcome.fxml is loaded, puts all radio buttons under the same toggle group
    public void initialize() {
        ToggleGroup outcomeToggle = new ToggleGroup();
        singleButton.setToggleGroup(outcomeToggle);
        doubleButton.setToggleGroup(outcomeToggle);
        tripleButton.setToggleGroup(outcomeToggle);
        homeRunButton.setToggleGroup(outcomeToggle);
        walkButton.setToggleGroup(outcomeToggle);
        outButton.setToggleGroup(outcomeToggle);
    }

    //Run when submit button is clicked, adds the selected outcome into the player object
    public void submit() throws Exception {
        if (singleButton.isSelected()) {
            player.add("single");
        } else if (doubleButton.isSelected()) {
            player.add("double");
        } else if (tripleButton.isSelected()) {
            player.add("triple");
        } else if (homeRunButton.isSelected()) {
            player.add("homer");
        } else if (walkButton.isSelected()) {
            player.add("walk");
        } else if (outButton.isSelected()) {
            player.add("out");
        } else {
            System.out.println("error: no outcome selected");
        }

        //Calls showStats method to move onto the next scene
        this.showStats();
    }

    //Method used to accept the player data from MainController
    public void updateStats(Player player) {
        this.player = player;
    }

    //Moves onto the screen that shows the player's current statistics
    public void showStats() throws Exception {
        //Loads layout from Stats.fxml into the program
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layouts/Stats.fxml"));
        Parent root = loader.load();

        //Saves the controller and passes player data into it
        StatsController controller = loader.getController();
        controller.updateStats(player);

        //Retrieves stage from AnchorPane in Outcome.fxml and sets the stage's scene to be the layout from Stats.fxml
        Stage window = (Stage) ap.getScene().getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);
    }
}
