import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent DatabaseViewScreen = FXMLLoader.load(getClass().getResource("FXMLFiles/Form.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(DatabaseViewScreen, 842, 738));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
