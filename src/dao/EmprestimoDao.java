package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Emprestimo;

import java.sql.Date;

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
            ps.setString (4, emprestimo.getCpf() );

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }  
    
    public static boolean renovar(Emprestimo emprestimo, Date dtDevolucao) {

        String sql;
        sql = "update Emprestimo";
        sql += "set dtDevolucao=? where idEmprestimo=?";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, dtDevolucao);

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }  
}
