package src.controladores;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class Controllers implements Initializable {

    @FXML
    private Button btnFunciona;

    @FXML
    private void sysoFunciona(ActionEvent event){
        System.out.println("¡FUNCIONA!");
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}