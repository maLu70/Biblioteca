package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            ps.setInt(2, livro.getnCopias());
            ps.setString(3, livro.getTitulo());
            ps.setString(4, livro.getEditora());
            ps.setString(5, livro.getAutor());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }

    public static boolean atualizarLivro(Livro livro, int anoPublicacao, int nCopias, String titulo, String editora,
            String autor) {

        String sql;
        sql = "update Livro ";
        sql += "set anoPublicacao=?, nCopias=?, titulo=?, editora=?, autor=? WHERE id=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, anoPublicacao);
            ps.setInt(2, nCopias);
            ps.setString(3, titulo);
            ps.setString(4, editora);
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

            ps.setInt(2, livro.getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO deletar: " + e.getMessage());
            return false;
        }
    }

    public static List<Livro> listar(String titulo) {

        List<Livro> lista = new ArrayList<Livro>();

        //String sql = "SELECT * FROM Livro where titulo=?";
        String sql = "SELECT * FROM Livro";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);
            
            //ps.setString(1, titulo);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setnCopias(rs.getInt("nCopias"));
                livro.setEditora(rs.getString("editora"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livro.setAutor(rs.getString("autor"));
                //livro.setEmprestimo(rs.getBoolean("emprestimo"));

                // livro.setIdLivro(rs.getInt("colCodigo"));
                // livro.setTitulo(rs.getString("colNome"));
                // livro.setnCopias(rs.getInt("colCopias"));
                // livro.setEditora(rs.getString("colEditora"));
                // livro.setAnoPublicacao(rs.getInt("colPublicacao"));
                // livro.setAutor(rs.getString("colAutor"));
                // livro.setEmprestimo(rs.getBoolean("colSituacao"));

                lista.add(livro);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }

    }
}
