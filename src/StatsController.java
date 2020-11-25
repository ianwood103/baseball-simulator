import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

//Controller class for Stats.fxml
public class StatsController {

    //Instantiates variables corresponding to node ids in Stats.fxml
    public AnchorPane ap;
    public Label averageLabel;
    public Label obpLabel;
    public Label slgLabel;
    public Label opsLabel;
    public Label homerLabel;
    public Label paLabel;

    //Instantiates player object so that controller can receive and store data from OutcomeController
    private Player player;

    //Accepts updated data from OutcomeController and displays it on the screen
    public void updateStats(Player player) {
        this.player = player;

        //Sets each label to hold its corresponding value for each statistic
        averageLabel.setText(String.valueOf(player.getAverage()));
        obpLabel.setText(String.valueOf(player.getOBP()));
        slgLabel.setText(String.valueOf(player.getSLG()));
        opsLabel.setText(String.valueOf(player.getOPS()));
        homerLabel.setText(String.valueOf(player.getHomers()));
        paLabel.setText(String.valueOf(player.getPlateAppearances()));

        this.saveStats();
    }

    //Sets the scene back to the main location setting scene to simulate another at-bat
    public void restart() throws Exception {
        //Loads data from Main.fxml into program
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();

        //Saves controller and passes updated player data into it
        MainController controller = loader.getController();
        controller.updateStats(player);

        //Retrieves stage from AnchorPane in Stats.fxml and sets the scene to be the layout from Main.fxml
        Stage window = (Stage) ap.getScene().getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);
    }

    //Method to save stats into player.json file
    public void saveStats() {

        //Creates new JSONObject called playerObject
        JSONObject playerObject = new JSONObject();

        //Puts the important stats into the new object
        playerObject.put("singles", player.getSingles());
        playerObject.put("doubles", player.getDoubles());
        playerObject.put("triples", player.getTriples());
        playerObject.put("homers", player.getHomers());
        playerObject.put("walks", player.getWalks());
        playerObject.put("outs", player.getOuts());

        //Writes this object into player.json file
        try (FileWriter file = new FileWriter("src/player.json")) {
            file.write(playerObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
