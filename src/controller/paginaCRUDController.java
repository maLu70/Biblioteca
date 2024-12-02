package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class paginaCRUDController {

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
    private TableView<?> tblAcervo;

    @FXML
    void editarLivro(ActionEvent event) {

    }

    @FXML
    void fazerEmprestimo(ActionEvent event) {

    }

    @FXML
    void registrarDevolucao(ActionEvent event) {

    }

    @FXML
    void removerLivro(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnVoltar.setBackground(lblResultado.getBackground());
    }

}
