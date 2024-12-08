package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Pessoa;

public class PessoaDao {

    public static boolean cadastrar(Pessoa usuario) {

        String sql;
        sql = "INSERT INTO pessoa (nome, telefone, dtNascimento, email, senha) ";
        sql += "VALUES (?, ?, ?, ?, ?)";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setInt    (2, usuario.getTelefone() );
            ps.setDate (3, usuario.getDtNascimento()    );
            ps.setString (4, usuario.getEmail() );
            ps.setString(5, usuario.getSenha());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }    
}
