package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;

public class paginaLivrosEmprestadosController {

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableView<?> tblEmprestimos;

    @FXML
    void devolucao(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnVoltar.setBackground(tblEmprestimos.getBackground());
    }
}
