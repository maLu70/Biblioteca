package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Livro;

public class LivroDao {

    public static boolean cadastrar(Livro livro) {

        String sql;
        sql = "INSERT INTO Livro (anoPublicacao, nCopias, titulo, editora, autor) ";
        sql += "VALUES (?, ?, ?, ?, ?)";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, livro.getAnoPublicacao());
            ps.setInt    (2, livro.getnCopias() );
            ps.setString (3, livro.getTitulo()    );
            ps.setString (4, livro.getEditora() );
            ps.setString(5, livro.getAutor());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    } 
    
    public static boolean atualizarLivro(Livro livro) {

        String sql;
        sql = "update Livro (anoPublicacao, nCopias, titulo, editora, autor) ";
        sql += "VALUES (?, ?, ?, ?, ?)";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, livro.getAnoPublicacao());
            ps.setInt    (2, livro.getnCopias() );
            ps.setString (3, livro.getTitulo()    );
            ps.setString (4, livro.getEditora() );
            ps.setString(5, livro.getAutor());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }

    }
}
