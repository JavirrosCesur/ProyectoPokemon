package src.controladores;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MenuPrincipalController implements Initializable {
    
    Stage stage;
	Scene scene;
	Parent root;
   
    @FXML
    Button combateBtn;
    @FXML
    Button capturarBtn;
    @FXML
    Button pcBtn;
    @FXML
    Button descansarBtn;
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private void combatir(ActionEvent event){
        System.out.println("¡combatiendo!");
    }

    @FXML
    private void capturar(ActionEvent e) throws IOException
    {
        System.out.println("capturando");

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/VistaCaptura.fxml"));
			
			root = loader.load();	
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();


    }

    @FXML
    private void computador(ActionEvent event)
    {
        System.out.println("abriendo el PC");
    }

    @FXML
    private void descansar(ActionEvent event)
    {
        System.out.println("descansando");
    }
}
