package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class ConexaoMySQL {

    //Atributos Estáticos (configuração do MySQL)
    private static Connection conexao;
    private static String host     = "localhost";
    private static String database = "Biblioteca";
    private static String login    = "root";
    private static String senha    = "nitaen123";

    public static Connection getConexao() {

        try {
            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName(host);
            ds.setDatabaseName(database);
            ds.setUser(login);
            ds.setPassword(senha);
            ds.setConnectTimeout(2000);

            conexao = ds.getConnection();

            System.out.println("CONECTADO AO BANCO MYSQL");

            return conexao;
            
        } catch (SQLException erro) {
            System.out.println("FALHA NA CONEXÃO:\n" + erro.getMessage());
            return null;
        }
    }    
}