package src.modelos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppPokemon extends Application {
    public static void main(String[] args) throws SQLException {
        
        launch(args);

        String url = "jdbc:mysql://localhost:3306/phpmyadmin";
        String user = "root";
        String password = "";
        Connection con = DriverManager.getConnection(url, user, password);

        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Conexión establecida.");

            con.close();
            System.out.println("Conexión cerrada.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
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