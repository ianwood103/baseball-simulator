import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//Main class that the program starts under
public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    //This method is run when the program is run
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //Loads fxml from Location.fxml into root
        FXMLLoader loader = new FXMLLoader(getClass().getResource("layouts/Start.fxml"));
        Parent root = loader.load();

        //Sets title to Baseball Simulator
        window.setTitle("Baseball Simulator");

        //Displays scene as seen in Location.fxml
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }
}
