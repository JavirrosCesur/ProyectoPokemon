package src.modelos;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppPokemon extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stagePrincipal) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/PrincipalPrueba.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            
            stagePrincipal.setScene(scene);
            stagePrincipal.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}