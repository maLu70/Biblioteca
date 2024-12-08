package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Emprestimo;

public class EmprestimoDao {

    public static boolean emprestar(Emprestimo emprestimo) {

        String sql;
        sql = "INSERT INTO Emprestimo (dtEmprestimo, dtDevolucao, idLivro, cpf) ";
        sql += "VALUES (?, ?, ?, ?)";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, emprestimo.getDtEmprestimo());
            ps.setDate    (2, emprestimo.getDtDevolucao() );
            ps.setInt (3, emprestimo.getIdLivro()    );
            ps.setInt (4, emprestimo.getCpf() );

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }    
}
