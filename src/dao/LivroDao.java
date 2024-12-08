package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Livro;

public class LivroDao {

    public static boolean cadastrarLivro(Livro livro) {

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
    
    public static boolean atualizarLivro(Livro livro, int anoPublicacao, int nCopias, String titulo, String editora, String autor) {

        String sql;
        sql = "update Livro ";
        sql += "set anoPublicacao=?, nCopias=?, titulo=?, editora=?, autor=? WHERE id=?";       

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, anoPublicacao);
            ps.setInt    (2, nCopias);
            ps.setString (3, titulo);
            ps.setString (4, editora);
            ps.setString(5, autor);
            ps.setInt(6, livro.getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO updtar: " + e.getMessage());
            return false;
        }

    }

    public static boolean delete(Livro livro) {
        String sql;
        sql = "delete * from Livro ";
        sql += "where idLivro=?"; 

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt    (2, livro.getIdLivro() );

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO deletar: " + e.getMessage());
            return false;
        }
    }
}
