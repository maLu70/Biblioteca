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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Livro;

public class paginaAcervoController {

    @FXML
    private Button btnVoltarAcervo;

    @FXML
    private TableColumn<Livro, String> colAutor;

    @FXML
    private TableColumn<Livro, Integer> colCodigo;

    @FXML
    private TableColumn<Livro, Integer> colCopias;

    @FXML
    private TableColumn<Livro, String> colEditora;

    @FXML
    private TableColumn<Livro, String> colNome;

    @FXML
    private TableColumn<Livro, Integer> colPublicacao;

    @FXML
    private TableColumn<Livro, String> colSituacao;

    @FXML
    private Label lblLabel;

    @FXML
    private TableView<Livro> tblAcervo;

    ObservableList<Livro> obsLiv;

    @FXML
    void initialize(String texto) {

        lblLabel.setText("Resultados para"+texto);
        btnVoltarAcervo.setBackground(lblLabel.getBackground());

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colCopias.setCellValueFactory(new PropertyValueFactory<>("nCopias"));
        colEditora.setCellValueFactory(new PropertyValueFactory<>("editora"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colPublicacao.setCellValueFactory(new PropertyValueFactory<>("anoPublicacao"));
        colSituacao.setCellValueFactory(new PropertyValueFactory<>("situacao"));

        obsLiv = FXCollections.observableList(LivroDao.listar(texto));
        System.out.println("pesquisa texto = " + texto);

        tblAcervo.setItems(obsLiv);
    }

    @FXML
    void voltarAcervo(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/paginaInicial.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

}
