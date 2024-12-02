package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class paginaAcervoController {

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblLabel;

    @FXML
    private TableView<?> tblAcervo;

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnVoltar.setBackground(lblLabel.getBackground());
    }

}
