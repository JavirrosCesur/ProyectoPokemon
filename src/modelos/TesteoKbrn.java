package src.modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteoKbrn {
    public static void main(String[] args) throws SQLException {
        
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

        int numero = (int)(Math.random()*16 + 1);

        rs = sttmt.executeQuery("SELECT * FROM pokemon INNER JOIN pokedex ON pokemon.ID_POKEDEX = pokedex.ID_POKEDEX;");
        for(int i = 1; i <= numero; i++){
            rs.next();
        }

        Pokemon pokemon = new Pokemon(rs.getString("NOMBRE"), rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"), rs.getInt("DEFENSA"), rs.getInt("ATK_ESPECIAL"), rs.getInt("DEF_ESPECIAL"), rs.getInt("VELOCIDAD"), Tipo.valueOf(rs.getString("TIPO1")), Tipo.valueOf(rs.getString("TIPO2")));

        System.out.println(pokemon.getNombre() + " " + pokemon.getVitalidadMaxima() + " " + pokemon.getAtaque() + 
        " " + pokemon.getDefensa() + " " + pokemon.getAtaqueEspecial() + " " + pokemon.getDefensaEspecial() + " " +
        pokemon.getVelocidad() + " " + pokemon.getTipo1() + " " + pokemon.getTipo2() + " " + pokemon.getGenero());
    }
}
