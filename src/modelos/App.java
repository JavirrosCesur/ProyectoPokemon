package modelos;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vistas/MenuPrincipal.fxml"));
            Scene scene = new Scene(root);
            Image image1 = new Image("../../Documents/ProyectoPokemon/rsc/Pokemon-UK-1.jpg");
            ImageView image2 = new ImageView("../../Documents/ProyectoPokemon/rsc/VIR-2713-62-cual-es-tu-nivel-d-unscreen.gif");
           
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
