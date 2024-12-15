package controller;

import java.io.IOException;
import java.net.URL;

import dao.PessoaDao;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pessoa;

public class PaginaLoginController {

    private static Pessoa logado; 

    public static Pessoa getLogado() {
        return logado;
    }

    public static void setLogado(Pessoa logado) {
        PaginaLoginController.logado = logado;
    }

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
    void Entrar(ActionEvent event) throws IOException {
        String cpf, senha;

        cpf = txtCPF.getText();
        senha = txtSenha.getText();

        if(PessoaDao.verificarLogin(cpf, senha) == false) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setHeaderText("Erro no Login");
            alert.setContentText("Preencha totas as informações corretamente");
            alert.show();
        } else {

            setLogado(PessoaDao.buscarPessoa(cpf));
            System.out.println(getLogado().isAdm());
            if (getLogado().isAdm()) {
                URL url = getClass().getResource("/view/telaInicialAdm.fxml");

                FXMLLoader loader = new FXMLLoader(url);
                Parent root = loader.load();
    
                Stage stgAcervo = new Stage();
                stgAcervo.setTitle("pagina inicial");
                stgAcervo.setScene(new Scene(root));
                stgAcervo.show();
    
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();

            }else if(getLogado().isAdm()==false){
            URL url = getClass().getResource("/view/paginaInicial.fxml");

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
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }

    @FXML
    void initialize() {
        btnSemConta.setBackground(txtCPF.getBackground());
    }

}
