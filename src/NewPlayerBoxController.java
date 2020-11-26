import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NewPlayerBoxController {

    public TextField playerField;
    public AnchorPane ap;

    public void onClick() throws Exception {
        System.out.println(playerField.getText());
        File file = new File("src/players/" + playerField.getText() + "/");
        file.mkdir();
        JSONObject playerObject = new JSONObject();

        //Puts the important stats into the new object
        playerObject.put("singles", 0);
        playerObject.put("doubles", 0);
        playerObject.put("triples", 0);
        playerObject.put("homers", 0);
        playerObject.put("walks", 0);
        playerObject.put("outs", 0);

        //Writes this object into player.json file
        try (FileWriter playerFile = new FileWriter(file.getPath() + "/player.json")) {
            playerFile.write(playerObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("layouts/Start.fxml"));
        Parent root = loader.load();

        Stage window = (Stage) ap.getScene().getWindow();
        window.setScene(new Scene(root));
    }
}
