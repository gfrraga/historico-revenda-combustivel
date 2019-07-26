package Controller;

import Controller.ConexaoBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaBD {
    private static PreparedStatement statement = null;

    public static ResultSet executarConsulta(String query) throws SQLException {
        statement = ConexaoBD.getConnection().prepareStatement(query);
        ResultSet resultSet         = statement.executeQuery();
        return resultSet;
    }

    public static void desconectarStatement() throws SQLException {
        if(statement != null){
            statement.close();
        }
    }
}
