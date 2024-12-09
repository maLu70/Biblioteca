package controller;

import java.io.IOException;
import java.net.URL;

import dao.LivroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Livro;

public class paginaCRUDController {

    public static Livro livroaux;
    
    public static Livro getLivro() {
        return livroaux;
    }

    public static void setLivro(Livro livroaux) {
        paginaCRUDController.livroaux = livroaux;
    }

    public static int deleteeedit;
    // 1 edit
    // 2 delete
    // 3 devolucao
    // 4 emprestar
    // 5 adicionar

    public static int getDeleteeedit() {
        return deleteeedit;
    }

    public void setDeleteeedit(int deleteeedit) {
        paginaCRUDController.deleteeedit = deleteeedit;
    }

    @FXML
    private TableColumn<Livro, String> colautor;

    @FXML
    private TableColumn<Livro, Integer> colcod;

    @FXML
    private TableColumn<Livro, Integer> colcopias;

    @FXML
    private TableColumn<Livro, String> coleditora;

    @FXML
    private TableColumn<Livro, String> colnome;

    @FXML
    private TableColumn<Livro, Integer> colpub;

    @FXML
    private TableColumn<Livro, String> colsituacao;

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEmprestar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblResultado;

    @FXML
    private TableView<Livro> tblAcervo;

    @FXML
    void editarLivro(ActionEvent event) throws IOException {
        livroaux = tblAcervo.getSelectionModel().getSelectedItem();
        setDeleteeedit(1);
        URL url = getClass().getResource("/view/paginaEdicaoAdicao.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página edição");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

    }

    @FXML
    void fazerEmprestimo(ActionEvent event) throws IOException {
        livroaux = tblAcervo.getSelectionModel().getSelectedItem();
        URL url = getClass().getResource("/view/telaEmprestimo.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página emprestimo");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        setDeleteeedit(4);

    }

    @FXML
    void registrarDevolucao(ActionEvent event) throws IOException {
        livroaux = tblAcervo.getSelectionModel().getSelectedItem();
        URL url = getClass().getResource("/view/telaEmprestimo.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página de Devolução");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        setDeleteeedit(3);

    }

    @FXML
    void removerLivro(ActionEvent event) throws IOException {
        Livro livroselecionado = tblAcervo.getSelectionModel().getSelectedItem();

        if (livroselecionado != null) {
            LivroDao.delete(livroselecionado);
        }

        colcod.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colcopias.setCellValueFactory(new PropertyValueFactory<>("nCopias"));
        coleditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colpub.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));
        colsituacao.setCellValueFactory(new PropertyValueFactory<>("situacao")); // colSituacao.setCellValueFactory(new
                                                                                 // PropertyValueFactory<>("emprestimo"));

        // obsLiv = FXCollections.observableArrayList();

        obsLiv = FXCollections.observableList(LivroDao.listar(null));

        tblAcervo.setItems(obsLiv);

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    ObservableList<Livro> obsLiv;

    @FXML
    void initialize() {
        btnVoltar.setBackground(lblResultado.getBackground());

        colcod.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colcopias.setCellValueFactory(new PropertyValueFactory<>("nCopias"));
        coleditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colpub.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));
        colsituacao.setCellValueFactory(new PropertyValueFactory<>("situacao")); // colSituacao.setCellValueFactory(new
                                                                                 // PropertyValueFactory<>("emprestimo"));

        // obsLiv = FXCollections.observableArrayList();

        obsLiv = FXCollections.observableList(LivroDao.listar(null));

        tblAcervo.setItems(obsLiv);

    }

}
