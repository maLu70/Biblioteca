package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private PasswordField txtLivro;

    @FXML
    private Label lblemprestimodevolucao;

    @FXML
    void Entrar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }

    @FXML
    void initialize() {
        btnVoltar.setBackground(txtCPF.getBackground());

        if (paginaCRUDController.getDeleteeedit() == 3) {
            lblemprestimodevolucao.setText("Empréstimo");
            btnEmprestar.setText("Realizar emprestimo");
            
            
        }else if (paginaCRUDController.getDeleteeedit() == 4) {
            lblemprestimodevolucao.setText("Devolção");
            btnEmprestar.setText("Realizar devolução");
            
        }
    }

    

}
