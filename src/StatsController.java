import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StatsController {
    private Player player;

    public AnchorPane ap;
    public Label averageLabel;
    public Label obpLabel;
    public Label slgLabel;
    public Label opsLabel;
    public Label homerLabel;
    public Label paLabel;

    public void updateStats(Player player) {
        this.player = player;

        averageLabel.setText(String.valueOf(player.getAverage()));
        obpLabel.setText(String.valueOf(player.getOBP()));
        slgLabel.setText(String.valueOf(player.getSLG()));
        opsLabel.setText(String.valueOf(player.getOPS()));
        homerLabel.setText(String.valueOf(player.getHomers()));
        paLabel.setText(String.valueOf(player.getPlateAppearances()));
    }

    public void restart() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();
        controller.updateStats(player);
        Stage window = (Stage) ap.getScene().getWindow();
        Scene scene = new Scene(root);
        window.setScene(scene);
    }
}
