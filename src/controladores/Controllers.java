package src.controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controllers implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Button btnFunciona;
    @FXML
    private void sysoFunciona(ActionEvent event){
        System.out.println("¡FUNCIONA!");
    }

    @FXML
    private Button btnDescubre;
    @FXML
    private void goToPrueba(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("../vistas/Prueba.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}