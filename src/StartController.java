import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class StartController {
    public VBox playerArea;
    public ScrollPane scrollView;
    public Button newButton;

    public void initialize() throws Exception {
        File playerPath = new File("src/players/");
        String players[] = playerPath.list();
        for(String player : players) {
            if (!player.equals(".DS_Store")) {
                this.loadButtons(player);
            }
        }
    }

    public void loadButtons(String playerName) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layouts/PlayerButton.fxml"));
        Button playerButton = (Button) loader.load();
        PlayerButtonController controller = loader.getController();

        Player tempPlayer = new Player();
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("src/players/" + playerName +"/player.json")) {
            JSONObject playerObject = (JSONObject) parser.parse(reader);
            int singles = ((Number) playerObject.get("singles")).intValue();
            int doubles = ((Number) playerObject.get("doubles")).intValue();
            int triples = ((Number) playerObject.get("triples")).intValue();
            int homers = ((Number) playerObject.get("homers")).intValue();
            int walks = ((Number) playerObject.get("walks")).intValue();
            int outs = ((Number) playerObject.get("outs")).intValue();
            tempPlayer = new Player(singles, doubles, triples, homers, walks, outs, playerName);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        controller.fillData(playerName, tempPlayer.getAverage(), tempPlayer.getOPS(), String.valueOf(tempPlayer.getHomers()), String.valueOf(tempPlayer.getAtBats()));
        playerArea.getChildren().add(playerButton);
    }

    public void newButtonClick() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layouts/NewPlayerBox.fxml"));
        AnchorPane newBox = (AnchorPane) loader.load();
        NewPlayerBoxController controller = loader.getController();

        newButton.setOnAction(e -> System.out.println("New player box already created"));
        playerArea.getChildren().add(newBox);
    }
}
