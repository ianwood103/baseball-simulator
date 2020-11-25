import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

//Main class that the program starts under
public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    //This method is run when the program is run
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Loads fxml from Main.fxml into root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();

        //Saves the controller for this layout into controller
        MainController controller = loader.getController();

        Player player = new Player();

        //Reads player data from player.json file and stores it in Player object named player
        JSONParser parser = new JSONParser();
        try (Reader reader = new FileReader("src/player.json")) {
            JSONObject playerObject = (JSONObject) parser.parse(reader);
            int singles = ((Number) playerObject.get("singles")).intValue();
            int doubles = ((Number) playerObject.get("doubles")).intValue();
            int triples = ((Number) playerObject.get("triples")).intValue();
            int homers = ((Number) playerObject.get("homers")).intValue();
            int walks = ((Number) playerObject.get("walks")).intValue();
            int outs = ((Number) playerObject.get("outs")).intValue();
            player = new Player(singles, doubles, triples, homers, walks, outs);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Passes player into the MainController
        controller.updateStats(player);

        //Sets title to Baseball Simulator
        window.setTitle("Baseball Simulator");

        //Displays scene as seen in Main.fxml
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
