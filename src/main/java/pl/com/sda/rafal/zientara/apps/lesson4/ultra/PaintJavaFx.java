package pl.com.sda.rafal.zientara.apps.lesson4.ultra;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaintJavaFx extends Application {

    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        PaintJavaFx.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(

                getClass()
                .getResource("/paint.fxml")


        );
        primaryStage.setTitle("Vector Paint Ultra!!! :D");
        Scene scene = new Scene(root, primaryStage.getWidth(),
                primaryStage.getHeight());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}