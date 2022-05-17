package src.controladores;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import src.modelos.Genero;
import src.modelos.Movimiento;
import src.modelos.Pokemon;
import src.modelos.Tipo;
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
    private void capturar(ActionEvent e) throws IOException, SQLException
    {
        System.out.println("capturando");

        String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/pokemon";
		Connection con = DriverManager.getConnection(url, usuario, "");;
		Statement stmt = con.createStatement();
        ResultSet rs2 = null;

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException i) {
			i.printStackTrace();
		}

        try {
			rs2 = stmt.executeQuery("SELECT * FROM pokemon inner join pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;");
            rs2.next();
		} catch (SQLException j) {
			j.printStackTrace();
		}

            Pokemon mipokemon = new Pokemon(rs2.getString("NOMBRE"), rs2.getInt("VITALIDAD"), rs2.getInt("ATAQUE"), rs2.getInt("DEFENSA"), rs2.getInt("ATK_ESPECIAL"), rs2.getInt("DEF_ESPECIAL"), rs2.getInt("VELOCIDAD"),Genero.valueOf("HEMBRA"), Tipo.valueOf(rs2.getString("TIPO1")),Tipo.valueOf(rs2.getString("TIPO2")), new ArrayList<Movimiento>());

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
