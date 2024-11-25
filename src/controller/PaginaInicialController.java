package controller;

import com.sun.prism.paint.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PaginaInicialController {

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnPesquisa;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void PesquisarAcervo(ActionEvent event) {

    }

    @FXML
    void clickLogin(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnEntrar.setBackground(txtPesquisa.getBackground());
    }

}
