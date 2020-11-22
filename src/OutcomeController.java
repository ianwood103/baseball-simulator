import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class OutcomeController {

    public RadioButton singleButton;
    public RadioButton doubleButton;
    public RadioButton tripleButton;
    public RadioButton homeRunButton;
    public RadioButton walkButton;
    public RadioButton outButton;
    public AnchorPane ap;
    private Player player;

    public void initialize() {
        ToggleGroup outcomeToggle = new ToggleGroup();
        singleButton.setToggleGroup(outcomeToggle);
        doubleButton.setToggleGroup(outcomeToggle);
        tripleButton.setToggleGroup(outcomeToggle);
        homeRunButton.setToggleGroup(outcomeToggle);
        walkButton.setToggleGroup(outcomeToggle);
        outButton.setToggleGroup(outcomeToggle);
    }

    public void submit() throws Exception{
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

        this.showStats();
    }

    public void updateStats(Player player) {
        this.player = player;
    }

    public void showStats() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Stats.fxml"));
        Parent root = loader.load();
        StatsController controller = loader.getController();
        controller.updateStats(player);
        Stage window = (Stage) ap.getScene().getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);
    }
}
