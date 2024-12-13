package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySQL;
import model.Livro;

public class LivroDao {

    public static boolean cadastrarLivro(Livro livro) {

        String sql;
        sql = "INSERT INTO Livro (anoPublicacao, nCopias, titulo, editora, autor, situacao) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, livro.getAnoPublicacao());
            ps.setInt(2, livro.getNCopias());
            ps.setString(3, livro.getTitulo());
            ps.setString(4, livro.getEditora());
            ps.setString(5, livro.getAutor());
            ps.setString(6, livro.getSituacao());

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
        sql += "set anoPublicacao=?, nCopias=?, titulo=?, editora=?, autor=? WHERE idLivro=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            
            ps.setInt(1, livro.getAnoPublicacao());
            ps.setInt(2, livro.getNCopias());
            ps.setString(3, livro.getTitulo());
            ps.setString(4, livro.getEditora());
            ps.setString(5, livro.getAutor());
            ps.setInt(6, livro.getIdLivro());
         
            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO updtar: " + e.getMessage());
            return false;
        }

    }

    public static boolean delete(Livro livro) {
        String sql;
        sql = "delete from Livro ";
        sql += "where idLivro=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, livro.getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO deletar: " + e.getMessage());
            return false;
        }
    }

    public static List<Livro> listar(String titulo) {
        List<Livro> lista = new ArrayList<Livro>();
    
        // A consulta foi modificada para filtrar pelo título (caso o parâmetro 'titulo' não seja nulo ou vazio)
        String sql = "SELECT * FROM Livro";
        
    if (titulo != null) {
        sql += " WHERE titulo LIKE ?";
        System.out.println("pesquisei");
    }

    try (Connection con = ConexaoMySQL.getConexao()) {
        PreparedStatement ps = con.prepareStatement(sql);

        if (titulo != null) {
            ps.setString(1, "%" + titulo + "%");
        }
    
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();

                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setNCopias(rs.getInt("nCopias"));
                livro.setEditora(rs.getString("editora"));
                livro.setAnoPublicacao(rs.getInt("anoPublicacao"));
                livro.setAutor(rs.getString("autor"));
                livro.setSituacao(rs.getString("situacao"));
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
