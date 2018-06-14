package klikker;



import javafx.application.Application;
import javafx.stage.Stage;

public class Controller extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            (new StartView()).startScherm();
        }


        public static void main(String[] args) {
            launch(args);
        }
   
}
