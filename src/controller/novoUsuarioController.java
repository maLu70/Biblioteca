package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pessoa;

import java.io.IOException;
import java.net.URL;

import dao.PessoaDao;

public class novoUsuarioController {

    @FXML
    private Button btnNewUsuario;

    @FXML
    private DatePicker dpNasci;

    @FXML
    private Label lblErroCPF;

    @FXML
    private Label lblErroSenha;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtNome;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private TextField txtTel;

    @FXML
    void CriarUsuario(ActionEvent event) throws IOException {

        if (VerificarCPF(txtCPF.getText()) && dpNasci.getValue() != null && txtEmail.getText().contains("@")
                && txtEmail.getText().length() > 10 && txtNome.getText() != null && txtSenha.getText() != null
                && txtCPF.getText().length() == 11) {

            Pessoa usuario = new Pessoa(txtCPF.getText(), Integer.parseInt(txtTel.getText()),
                    txtNome.getText(), txtEmail.getText(), txtSenha.getText(), false, dpNasci.getValue());

            PessoaDao.cadastrarUsuario(usuario);

            URL url = getClass().getResource("/view/paginaLogin.fxml");

            FXMLLoader loader = new FXMLLoader(url);

            Parent root = loader.load();

            Stage stgAcervo = new Stage();
            stgAcervo.setTitle("Pagina de Login");
            stgAcervo.setScene(new Scene(root));
            stgAcervo.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();

            System.out.println("usuario adicionado");
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Erro no Cadastro");
            alert.setContentText("Preencha totas as informações corretamente");
            alert.show();
        }
    }

    public Boolean VerificarCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        int soma1 = 0, soma2 = 0, peso = 10, digitoverificador1, digitoverificador2;

        for (int cont = 0; cont < 9; cont++) {
            soma1 += Integer.parseInt(cpf.substring(cont, cont + 1)) * peso--;
        }
        digitoverificador1 = soma1 % 11;
        if (digitoverificador1 < 2) {
            digitoverificador1 = 0;
        } else {
            digitoverificador1 = 11 - digitoverificador1;
        }

        int peso2 = 11;
        for (int cont = 0; cont < 10; cont++) {
            soma2 += Integer.parseInt(cpf.substring(cont, cont + 1)) * peso2--;
        }
        digitoverificador2 = soma2 % 11;
        if (digitoverificador2 < 2) {
            digitoverificador2 = 0;

        } else {
            digitoverificador2 = 11 - digitoverificador2;
        }

        return cpf.charAt(9) == (char) (digitoverificador1 + '0')
                && cpf.charAt(10) == (char) (digitoverificador2 + '0');
    }
}
