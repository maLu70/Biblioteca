package model;

import java.sql.Date;

public class Emprestimo {
    Date dtEmprestimo, dtDevolucao;
    int idEmprestimo;
    Livro livro;
    Pessoa pessoa;
    String situacao;

    public Emprestimo(Date dtEmprestimo, Date dtDevolucao, int idEmprestimo, Livro livro, Pessoa pessoa) {
        this.dtEmprestimo = dtEmprestimo;
        this.dtDevolucao = dtDevolucao;
        this.idEmprestimo = idEmprestimo;
        this.livro = livro;
        this.pessoa = pessoa;
    }

    public Emprestimo() {
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDtEmprestimo() {
        return dtEmprestimo;
    }

    public void setDtEmprestimo(Date dtEmprestimo) {
        this.dtEmprestimo = dtEmprestimo;
    }

    public Date getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Date dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    } 
    
    public String getLivroTitulo() {
        return livro != null ? livro.getTitulo() : "";
    }

    public String getLivroAutor() {
        return livro != null ? livro.getAutor() : "";
    }

    public String getLivroEditora() {
        return livro != null ? livro.getEditora() : "";
    }

    public String getPessoaCpf() {
        return pessoa != null ? pessoa.getCpf() : "";
    }
}


