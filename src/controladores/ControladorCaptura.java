package src.controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import src.modelos.Captura;

public class ControladorCaptura {
    
    @FXML
    Button capturarBtn;

    @FXML
    Button huirBtn;

    @FXML
    private void capturar(ActionEvent event) throws SQLException
    {
        System.out.println("tirando pokeball");
        Captura captura = new Captura();
       /* boolean resultado = captura.getEntrenador().capturarPokemon(captura.getPokemon());

        if(resultado)
        {

            //para la base de datos

        }*/

        //MIERDAS

        String usuario = "root";
		String clave = "Ff/8475261238";
		String url = "jdbc:mysql://localhost:3306/pokemon";
		Connection con = DriverManager.getConnection(url, usuario, "");;
		Statement stmt = con.createStatement();
		ResultSet rs;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("hola");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
            //con = DriverManager.getConnection(url,usuario,clave);
			//stmt = con.createStatement();
			//stmt.executeUpdate("INSERT INTO city VALUES(10000,'CORVERA','ABW','CALLE JC1',123456)");
			//stmt.executeUpdate("INSERT INTO city VALUES(18523,'SHIT','ABW','CALLE CESUR',123456)");
			rs = stmt.executeQuery("SELECT * FROM entrenador" );
			rs.next();
			
			do {
				
				System.out.println("ID: " + rs.getString("ID_ENTRENADOR") + " NOMBRE: " + rs.getString("NOMBRE") + " POKEDOLARES: " + rs.getString("POKEDOLARES"));
				
			}while(rs.next());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


    }

}
