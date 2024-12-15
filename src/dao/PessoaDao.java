package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import jdbc.ConexaoMySQL;
import model.Pessoa;

public class PessoaDao {

    public static boolean cadastrarUsuario(Pessoa usuario) {

        String sql;
        sql = "INSERT INTO pessoa (nome, telefone, dtNascimento, email, senha, cpf, adm) ";
        sql += "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, usuario.getNome());
            ps.setInt(2, usuario.getTelefone());
            ps.setObject(3, usuario.getDtNascimento());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getSenha());
            ps.setString(6, usuario.getCpf());
            ps.setObject(7, usuario.isAdm());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }

    public static boolean atualizarCadastroUsuario(Pessoa usuario, String nome, int telefone, String email,
            String senha, LocalDate dtNascimento) {

        String sql;
        sql = "Update pessoa";
        sql += "set nome=?, telefone=?, dtNascimento=?, email=?, senha=? where cpf=?";

        try (Connection con = ConexaoMySQL.getConexao()) {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, nome);
            ps.setInt(2, telefone);
            ps.setObject(3, dtNascimento);
            ps.setString(4, email);
            ps.setString(5, senha);
            ps.setString(6, usuario.getCpf());

            return (ps.executeUpdate() > 0);

        } catch (SQLException e) {
            System.out.println("ERRO AO INSERIR: " + e.getMessage());
            return false;
        }
    }

    public static boolean verificarLogin(String cpf, String senha) {
        String sql = "SELECT senha FROM pessoa WHERE cpf = ?";
    
        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String senhaCerta = rs.getString("senha");
                System.out.println("senhacerta = " +senhaCerta);
                System.out.println("achei cpf");
    
                if (senha.equals(senhaCerta)) {
                    System.out.println("foi");
                    return true;
                } else {
                    System.out.println("arruma a senha aí");
                    return false;
                }
            } else {
                System.out.println("cpf errado");
                return false;
            }
            
        } catch (SQLException e) {
            System.out.println("ERRO AO logar: " + e.getMessage());
            return false;
        }
    }
    

    public static Pessoa buscarPessoa(String cpf) {
        String sql = "SELECT * FROM pessoa WHERE cpf = ?";
        
        try (Connection con = ConexaoMySQL.getConexao()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cpf);
    
            ResultSet rs = ps.executeQuery();
    
            if (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setTelefone(rs.getInt("telefone"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setSenha(rs.getString("senha"));
                pessoa.setAdm(rs.getBoolean("adm"));
                pessoa.setDtNascimento(rs.getObject("dtNascimento", LocalDate.class));
    
                return pessoa;
            } else {
                System.out.println("Usuário não encontrado ou senha incorreta.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR USUÁRIO: " + e.getMessage());
            return null;
        }
    }
    

    // public static boolean deletarUsuario(Pessoa usuario) {
    // String sql;
    // sql = "delete * from Pessoa ";
    // sql += "where cpf=?";

    // try (Connection con = ConexaoMySQL.getConexao()) {

    // PreparedStatement ps = con.prepareStatement(sql);

    // ps.setInt (2, usuario.getCpf() );

    // return (ps.executeUpdate() > 0);

    // } catch (SQLException e) {
    // System.out.println("ERRO AO deletar usuario: " + e.getMessage());
    // return false;
    // }
    // }

}
