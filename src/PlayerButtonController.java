import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class PlayerButtonController {

    public Button playerButton;
    public Label playerLabel;
    public Label avgLabel;
    public Label opsLabel;
    public Label homerLabel;
    public Label abLabel;

    private String globalName;

    public void fillData(String playerName, String average, String ops, String homers, String atBats) {
        playerLabel.setText(playerName);
        avgLabel.setText(average);
        opsLabel.setText(ops);
        homerLabel.setText(homers);
        abLabel.setText(atBats);
        globalName = playerName;
    }

    public void onClick() throws Exception {

        Stage window = (Stage) playerButton.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Location.fxml"));
        Parent root = loader.load();

        //Saves the controller for this layout into controller
        LocationController controller = loader.getController();

        Player player = new Player();

        //Reads player data from player.json file and stores it in Player object named player
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("src/players/" + globalName +"/player.json")) {
            JSONObject playerObject = (JSONObject) parser.parse(reader);
            int singles = ((Number) playerObject.get("singles")).intValue();
            int doubles = ((Number) playerObject.get("doubles")).intValue();
            int triples = ((Number) playerObject.get("triples")).intValue();
            int homers = ((Number) playerObject.get("homers")).intValue();
            int walks = ((Number) playerObject.get("walks")).intValue();
            int outs = ((Number) playerObject.get("outs")).intValue();
            player = new Player(singles, doubles, triples, homers, walks, outs, globalName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Passes player into the LocationController
        controller.updateStats(player);

        window.setScene(new Scene(root));
    }
}
