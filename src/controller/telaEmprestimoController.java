package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaEmprestimoController {

    @FXML
    private Button btnEmprestar;

    @FXML
    private Button btnVoltar;

    @FXML
    private Label lblErroCPF;

    @FXML
    private Label lblErroSenha;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtLivro;

    @FXML
    private Label lblemprestimodevolucao;

    @FXML
    void Entrar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
         URL url = getClass().getResource("/view/paginaCRUD.fxml");

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stgAcervo = new Stage();
            stgAcervo.setTitle("pagina CRUD");
            stgAcervo.setScene(new Scene(root));
            stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() {
        btnVoltar.setBackground(txtCPF.getBackground());
        if (paginaCRUDController.getLivro() != null) {
        txtLivro.setText(Integer.toString(paginaCRUDController.getLivro().getIdLivro()));
        }
        if (paginaCRUDController.getDeleteeedit() == 3) {
            lblemprestimodevolucao.setText("Empréstimo");
            btnEmprestar.setText("Realizar emprestimo");
            
            
        }else if (paginaCRUDController.getDeleteeedit() == 4) {
            lblemprestimodevolucao.setText("Devolção");
            btnEmprestar.setText("Realizar devolução");
            if (paginaCRUDController.getLivro() != null) {
                txtLivro.setText(Integer.toString(paginaCRUDController.getLivro().getIdLivro()));
            }
        }
    }

    

}
