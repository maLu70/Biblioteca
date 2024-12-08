package model;

import java.sql.Date;

public class Pessoa {
    int cpf, telefone;
    String nome, email, senha;
    boolean adm;
    Date dtNascimento;

    public Pessoa() {
    }

    public Pessoa(int cpf, int telefone, String nome, String email, String senha, boolean adm, Date dtNascimento) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.adm = adm;
        this.dtNascimento = dtNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdm() {
        return adm;
    }

    public void setAdm(boolean adm) {
        this.adm = adm;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
}
