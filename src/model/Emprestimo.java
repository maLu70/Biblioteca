package model;

import java.sql.Date;

public class Emprestimo {
    Date dtEmprestimo, dtDevolucao;
    int idEmprestimo, idLivro, cpf;

    public Emprestimo(Date dtEmprestimo, Date dtDevolucao, int idEmprestimo, int idLivro, int cpf) {
        this.dtEmprestimo = dtEmprestimo;
        this.dtDevolucao = dtDevolucao;
        this.idEmprestimo = idEmprestimo;
        this.idLivro = idLivro;
        this.cpf = cpf;
    }

    public Emprestimo() {
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

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

}
