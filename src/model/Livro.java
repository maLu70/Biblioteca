package model;

public class Livro {
    int idLivro, anoPublicacao, nCopias;
    String titulo, editora, autor;
    boolean emprestimo;
    String situacao;

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public Livro(int anoPublicacao, int nCopias, String titulo, String editora, String autor, String situacao) {
        this.anoPublicacao = anoPublicacao;
        this.nCopias = nCopias;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Livro() {
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNCopias() {
        return nCopias;
    }

    public void setNCopias(int nCopias) {
        this.nCopias = nCopias;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
