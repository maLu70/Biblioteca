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

                lista.add(livro);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    public static List<Livro> listarporautr(String titulo) {
        List<Livro> lista = new ArrayList<Livro>();

        String sql = "SELECT * FROM Livro";

        if (titulo != null) {
            sql += " WHERE autor LIKE ?";
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

                lista.add(livro);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    public static List<Livro> listareditora(String titulo) {
        List<Livro> lista = new ArrayList<Livro>();

        String sql = "SELECT * FROM Livro";

        if (titulo != null) {
            sql += " WHERE editora LIKE ?";
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
            
                lista.add(livro);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }
    public static List<Livro> listartudo(String titulo) {
        List<Livro> lista = new ArrayList<Livro>();

        String sql = "SELECT * FROM Livro";

        if (titulo != null) {
            sql += " WHERE editora LIKE ? or titulo LIKE ? or autor LIKE ?";
            System.out.println("pesquisei");
        }

        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            if (titulo != null) {
                ps.setString(1, "%" + titulo + "%");
                ps.setString(2, "%" + titulo + "%");
                ps.setString(3, "%" + titulo + "%");
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
            
                lista.add(livro);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    public static boolean devolucao(Livro livro) {
        String sql;
        sql = "update Livro ";
        sql += "set situacao=? WHERE idLivro=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "livre");
            ps.setInt(2, livro.getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO devolver: " + e.getMessage());
            return false;
        }
    }
}
