package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.ConexaoMySQL;
import model.Pessoa;

import java.sql.Date;

public class PessoaDao {

    public static boolean cadastrarUsuario(Pessoa usuario) {

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

    public static boolean atualizarCadastroUsuario(Pessoa usuario, String nome, int telefone, String email, String senha, Date dtNascimento) {

        String sql;
        sql = "Update pessoa";
        sql += "set nome=?, telefone=?, dtNascimento=?, email=?, senha=? where cpf=?";        

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setInt    (2, telefone);
            ps.setDate (3, dtNascimento);
            ps.setString (4, email);
            ps.setString(5, senha);
            ps.setInt(6, usuario.getCpf());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }    

    public static boolean deletarUsuario(Pessoa usuario) {
        String sql;
        sql = "delete * from Pessoa ";
        sql += "where cpf=?"; 

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt    (2, usuario.getCpf() );

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO deletar usuario: " + e.getMessage());
            return false;
        }
    }
    
}
