package controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;

import dao.EmprestimoDao;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.*;

public class paginaLivrosEmprestadosController {

    public static Livro livroaux;

    public static Livro getLivro() {
        return livroaux;
    }

    public static void setLivro(Livro livroaux) {
        paginaLivrosEmprestadosController.livroaux = livroaux;
    }

    @FXML
    private TableColumn<Livro, String> autor;

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Emprestimo, Integer> codigo;

    @FXML
    private TableColumn<Emprestimo, Date> devolucao;

    @FXML
    private TableColumn<Emprestimo, Date> emprestimo;

    @FXML
    private TableView<Emprestimo> tblEmprestimos;

    @FXML
    private TableColumn<Emprestimo, String> titulo;

    @FXML
    private TableColumn<Emprestimo, String> editora;

    @FXML
    private TableColumn<Emprestimo, Integer> usuario;

    ObservableList<Emprestimo> obsLiv;

    @FXML
    void initialize() {
        btnVoltar.setBackground(tblEmprestimos.getBackground());

        codigo.setCellValueFactory(new PropertyValueFactory<>("idEmprestimo"));
        autor.setCellValueFactory(new PropertyValueFactory<>("livroAutor"));
        devolucao.setCellValueFactory(new PropertyValueFactory<>("dtDevolucao"));
        emprestimo.setCellValueFactory(new PropertyValueFactory<>("dtEmprestimo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("livroTitulo"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("pessoaCpf"));
        editora.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        obsLiv = FXCollections.observableList(EmprestimoDao.listarEmprestimo());
        System.out.println(obsLiv.size());

        tblEmprestimos.setItems(obsLiv);
    }

    @FXML
    void devolucao(ActionEvent event) {

        livroaux = tblEmprestimos.getSelectionModel().getSelectedItem().getLivro();
        LivroDao.devolucao(livroaux);
    }


    @FXML
    void voltar(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/telaInicialAdm.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("pagina inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }
}
