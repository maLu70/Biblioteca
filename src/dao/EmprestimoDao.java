package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConexaoMySQL;
import model.Emprestimo;

public class EmprestimoDao {

    public static boolean emprestar(Emprestimo emprestimo) {

        String sql;
        sql = "INSERT INTO Emprestimo (dtEmprestimo, dtDevolucao, idLivro, cpf, situacao) ";
        sql += "VALUES (?, ?, ?, ?, ?)";

        // sql += "update Livro set situacao=? where idLivro=?;";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setObject(1, emprestimo.getDtEmprestimo());
            ps.setObject(2, emprestimo.getDtDevolucao());
            ps.setInt(3, emprestimo.getLivro().getIdLivro());
            ps.setString(4, emprestimo.getPessoa().getCpf());
            ps.setString(5, "em dia");

            // ps.setString(6, "emprestado");
            // ps.setInt(7, emprestimo.getLivro().getIdLivro());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO emprestar: " + e.getMessage());
            return false;
        }

    }

    public static List<Emprestimo> listarEmprestimo() {
        List<Emprestimo> lista = new ArrayList<Emprestimo>();

        String sql = "SELECT * FROM emprestimo WHERE situacao LIKE ? OR situacao LIKE ?";

        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%em dia%");
            ps.setString(2, "%atrasado%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();

                emprestimo.setIdEmprestimo(rs.getInt("idEmprestimo"));
                emprestimo.setDtEmprestimo(rs.getDate("dtEmprestimo"));
                emprestimo.setDtDevolucao(rs.getDate("dtDevolucao"));
                emprestimo.setSituacao(rs.getString("situacao"));
                emprestimo.setLivro(LivroDao.buscarLivroPorId(rs.getInt("idLivro")));
                emprestimo.setPessoa(PessoaDao.buscarPessoa(rs.getString("cpf")));

                lista.add(emprestimo);
            }

            return lista;

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            return null;
        }
    }

    public static boolean devolver(int id) {

        String sql = "update emprestimo set situacao=? WHERE idEmprestimo=?";

        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "inativo");
            ps.setInt(2, id);

            return (ps.executeUpdate() > 0);

        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
            return false;
        }
    }

}