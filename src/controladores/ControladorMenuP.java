package src.controladores;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
//import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.modelos.*;
import src.modelos.Tipo;
import javafx.scene.Node;

public class ControladorMenuP implements Initializable {
    
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
    @FXML
    Button salirButton;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    }

    @FXML
    private void combatir(ActionEvent event){
        System.out.println("¡combatiendo!");
    }

    @FXML
    private void salir(ActionEvent event){
       System.exit(0);
    }

    @FXML
    private void capturar(ActionEvent e) throws IOException, SQLException {
        System.out.println("capturando");

        String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/pokemon";
		Connection con = DriverManager.getConnection(url, usuario, "");;
		Statement stmt = con.createStatement();
        ResultSet rs2 = null;
        ResultSet rs =null;

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException i) {
			i.printStackTrace();
		}
        try {
            rs = stmt.executeQuery("SELECT COUNT(ID_POKEMON) FROM pokemon;");
            rs.next();
            int cantidad = rs.getInt(1);

            int numero = (int)(Math.random()*(cantidad-1+1)+1);

            rs2 = stmt.executeQuery("SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;");
            for (int i = 1; i <= numero; i++)
            {
                rs2.next();
            }   
		} catch (SQLException j) {
			j.printStackTrace();
		}

            

            Pokemon mipokemon = new Pokemon(rs2.getString("NOMBRE"), rs2.getInt("VITALIDAD"), rs2.getInt("ATAQUE"), rs2.getInt("DEFENSA"), rs2.getInt("ATK_ESPECIAL"), rs2.getInt("DEF_ESPECIAL"), rs2.getInt("VELOCIDAD"),Tipo.valueOf(rs2.getString("TIPO1")),Tipo.valueOf(rs2.getString("TIPO2")));

            FXMLLoader loader = new FXMLLoader(getClass().getResource("../vistas/VistaCaptura.fxml"));
			root = loader.load();	
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);


           ControladorCaptura controller = loader.getController();
           controller.setPokemon(mipokemon);

			stage.show();


    }

    @FXML
    private void computador(ActionEvent event) {
        System.out.println("abriendo el PC");
    }

    @FXML
    private void descansar(ActionEvent event) {
        System.out.println("descansando");
    }
}