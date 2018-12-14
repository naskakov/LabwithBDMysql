import javafx.application.Application;
import javafx.stage.Stage;
import View.MainWindow;

public class Main extends Application {
    public void start(Stage primaryStage){
        MainWindow mainWindow=new MainWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
