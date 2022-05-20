package src.controladores;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.Resultset;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import src.modelos.Pokemon;
import src.modelos.Tipo;

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

        @FXML
        private Button btnCapturarMP;
        @FXML
        private void goToVistaCaptura(ActionEvent event) throws IOException, SQLException {

        String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);
        Statement sttmt = con.createStatement();
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conexión establecida.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        rs = sttmt.executeQuery("SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;");
        for(int i = 1; i <= 16; i++){
            rs.next();
        }

        Pokemon pokemon = new Pokemon(rs.getString("NOMBRE"), rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"), rs.getInt("DEFENSA"), rs.getInt("ATK_ESPECIAL"), rs.getInt("DEF_ESPECIAL"), rs.getInt("VELOCIDAD"), Tipo.valueOf(rs.getString("TIPO1")), Tipo.valueOf(rs.getString("TIPO2")));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/EscenarioCapturaJc.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        Controllers controller = loader.getController();
        controller.setPokemon(pokemon);
        
        stage.show();


    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
}