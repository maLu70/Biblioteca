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

        sql += "update Livro set situacao=? where idLivro=?";

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

    // public static List<Emprestimo> listarEmprestimo() {
    // List<Emprestimo> lista = new ArrayList<Emprestimo>();

    // String sql = "SELECT * FROM emprestimo";
    // sql += " WHERE situacao LIKE ? or situacao like ?";

    // try (Connection con = ConexaoMySQL.getConexao()) {
    // PreparedStatement ps = con.prepareStatement(sql);

    // ps.setString(1, "%em dia%");
    // ps.setString(2, "%atrasado%");

    // ResultSet rs = ps.executeQuery();

    // while (rs.next()) {
    // Emprestimo emprestimo = new Emprestimo();

    // emprestimo.setDtEmprestimo(rs.getDate("dtEmprestimo"));
    // emprestimo.setDtDevolucao(rs.getDate("dtDevolucao"));
    // emprestimo.setSituacao(rs.getString("situacao"));

    // int idLivro = rs.getInt("idLivro");

    // Livro livro = buscarLivro(idLivro);
    // emprestimo.setLivro(livro);

    // System.out.print(emprestimo.getLivro().getTitulo());

    // lista.add(emprestimo);

    // System.out.println("adicionei emprestimo");

    // }

    // return lista;

    // } catch (SQLException erro) {
    // System.out.println("ERRO: " + erro.getMessage());
    // return null;
    // }
    // }

    // private static Livro buscarLivro(int id) {
    // String sql = "SELECT * FROM livro WHERE idLivro = ?";

    // System.out.println("comecei procurar o livro");

    // try (Connection con = ConexaoMySQL.getConexao()) {
    // PreparedStatement ps = con.prepareStatement(sql);
    // ps.setInt(1, id);
    // ResultSet rs = ps.executeQuery();

    // if (rs.next()) {
    // Livro livro = new Livro();

    // livro.setIdLivro(rs.getInt("idLivro"));
    // livro.setTitulo(rs.getString("titulo"));
    // livro.setAutor(rs.getString("autor"));

    // System.out.println(livro.getTitulo());

    // return livro;
    // }
    // } catch (SQLException e) {
    // System.out.println("ERRO livro: " + e.getMessage());
    // return null;
    // }

    // return null;
    // }

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

}