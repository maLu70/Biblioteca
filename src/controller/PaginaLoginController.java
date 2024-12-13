package controller;

import java.io.IOException;
import java.net.URL;

import dao.PessoaDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        String cpf, senha;

        cpf = txtCPF.getText();
        senha = txtSenha.getText();

        if(PessoaDao.verificarLogin(cpf, senha) == false) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Erro no Login");
            alert.setContentText("Preencha totas as informações corretamente");
            alert.show();
        } else {
            System.out.println("logado");
        }
    }

    @FXML
    void criarConta(ActionEvent event) throws IOException {

        URL url = getClass().getResource("/view/novoUsuario.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página Inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

    }

    @FXML
    void initialize() {
        btnSemConta.setBackground(txtCPF.getBackground());
    }

}
