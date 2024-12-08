package model;

public class Livro {
    int idLivro, anoPublicacao, nCopias;
    String titulo, editora, autor;

    public Livro(int idLivro, int anoPublicacao, int nCopias, String titulo, String editora, String autor) {
        this.idLivro = idLivro;
        this.anoPublicacao = anoPublicacao;
        this.nCopias = nCopias;
        this.titulo = titulo;
        this.editora = editora;
        this.autor = autor;
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

    public int getnCopias() {
        return nCopias;
    }

    public void setnCopias(int nCopias) {
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
