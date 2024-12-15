package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySQL;
import model.Emprestimo;
import model.Livro;
import model.Pessoa;

public class EmprestimoDao {

    public static boolean emprestar(Emprestimo emprestimo) {

        String sql;
        sql = "INSERT INTO Emprestimo (dtEmprestimo, dtDevolucao, idLivro, cpf, situacao) ";
        sql += "VALUES (?, ?, ?, ?, ?)";

        sql += "update Livro set situacao=? where=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, emprestimo.getDtEmprestimo());
            ps.setDate(2, emprestimo.getDtDevolucao());
            ps.setInt(3, emprestimo.getLivro().getIdLivro());
            ps.setString(4, emprestimo.getPessoa().getCpf());
            ps.setString(5, "ativo");

            ps.setString(6, "emprestado");
            ps.setInt(7, emprestimo.getLivro().getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO emprestar: " + e.getMessage());
            return false;
        }
    }

    public static List<Emprestimo> listarEmprestimo() {
        List<Emprestimo> lista = new ArrayList<Emprestimo>();

        String sql = "SELECT * FROM emprestimo";
        sql += " WHERE situacao LIKE ? or situacao like ?";

        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "%ativo%");
            ps.setString(2, "%em atraso%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setDtEmprestimo(rs.getDate("dtEmprestimo"));
                emprestimo.setDtDevolucao(rs.getDate("dtDevolucao"));
                emprestimo.setSituacao(rs.getString("situacao"));

                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                emprestimo.setLivro(livro);

                Pessoa usuario = new Pessoa();
                usuario.setCpf(rs.getString("cpf"));
                emprestimo.setPessoa(usuario);

                lista.add(emprestimo);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("ERRO: " + erro.getMessage());
            return null;
        }
    }

    // public static boolean renovar(Emprestimo emprestimo, Date dtDevolucao) {

    // String sql;
    // sql = "update Emprestimo";
    // sql += "set dtDevolucao=? where idEmprestimo=?";

    // try (Connection con = ConexaoMySQL.getConexao()) {

    // PreparedStatement ps = con.prepareStatement(sql);

    // ps.setDate(1, dtDevolucao);

    // return (ps.executeUpdate() > 0);

    // } catch (SQLException e) {
    // System.out.println("ERRO AO renovar: " + e.getMessage());
    // return false;
    // }
    // }
}
