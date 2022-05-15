package controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controllers implements Initializable{

    @FXML
    private Button btnMenuCaptura;

    @FXML
    private void irACapturar(ActionEvent event){
        System.out.println("Capturar");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
}