import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Parent root = loader.load();
        MainController controller = loader.getController();

        Player player = new Player();
        player.add("single");
        controller.updateStats(player);

        window.setTitle("Baseball Simulator");
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
