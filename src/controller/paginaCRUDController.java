package controller;

import java.io.IOException;
import java.net.URL;

import dao.LivroDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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

    public static void setDeleteeedit(int deleteeedit) {
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
    Label lblResultado;

    @FXML
    private TableView<Livro> tblAcervo;

    @FXML
    void editarLivro(ActionEvent event) throws IOException {
        livroaux = tblAcervo.getSelectionModel().getSelectedItem();

        if (livroaux == null) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setHeaderText("Erro ao atualizar livro");
            alerta.setContentText("selecione um livro para atualizar");
            alerta.show();
        } else {
            setDeleteeedit(1);
            URL url = getClass().getResource("/view/paginaEdicaoAdicao.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();
            Stage stgAcervo = new Stage();
            stgAcervo.setTitle("Página edição");
            stgAcervo.setScene(new Scene(root));
            stgAcervo.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

        }

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

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

        setDeleteeedit(4);
    }

    @FXML
    void registrarDevolucao(ActionEvent event) throws IOException {

        livroaux = tblAcervo.getSelectionModel().getSelectedItem();

        if (livroaux == null || (livroaux.getSituacao() == "livre")) {
            Alert alerta = new Alert(AlertType.INFORMATION);
            alerta.setHeaderText("Erro ao registrar devolução");
            alerta.setContentText("selecione um livro para devolver");
            alerta.show();

        } else {
            System.out.println("aqui");
            LivroDao.devolucao(livroaux);
        }

        setDeleteeedit(3);
    }

    @FXML
    void removerLivro(ActionEvent event) throws IOException {
        Livro livroselecionado = tblAcervo.getSelectionModel().getSelectedItem();

        if (livroselecionado != null) {
            LivroDao.delete(livroselecionado);
        }

        else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Erro ao deletar");
            alert.setContentText("Selcione um livro");
            alert.show();
        }

        colcod.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colcopias.setCellValueFactory(new PropertyValueFactory<>("nCopias"));
        coleditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colpub.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));
        colsituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        obsLiv = FXCollections.observableList(LivroDao.listartudo(""));

        tblAcervo.setItems(obsLiv);
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/telaInicialAdm.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    ObservableList<Livro> obsLiv;

    @FXML
    void initialize(String titulo) {
        btnVoltar.setBackground(lblResultado.getBackground());

        colcod.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        colautor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colcopias.setCellValueFactory(new PropertyValueFactory<>("nCopias"));
        coleditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colnome.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colpub.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));
        colsituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        obsLiv = FXCollections.observableList(LivroDao.listar(titulo));

        tblAcervo.setItems(obsLiv);

    }

}
