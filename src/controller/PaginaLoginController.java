package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PaginaLoginController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnSemConta;

    @FXML
    private Label lblErroCPF;

    @FXML
    private Label lblErroSenha;

    @FXML
    private TextField txtCPF;

    @FXML
    private PasswordField txtSenha;

    @FXML
    void Entrar(ActionEvent event) {

    }

    @FXML
    void criarConta(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnSemConta.setBackground(txtCPF.getBackground());
    }

}
