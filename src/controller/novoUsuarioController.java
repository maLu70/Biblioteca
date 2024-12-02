package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    void CriarUsuario(ActionEvent event) {

    }

    public Boolean VerificarCPF(String cpf) {

        int somadocpf =0, digitoverificador, soma2=0;
        String[] arraycpf = cpf.split(cpf);

        for(int cont = 0 ; cont < arraycpf.length ; cont++){
            somadocpf = Integer.parseInt(arraycpf[cont])*Integer.parseInt(arraycpf[cont]);
        }
        digitoverificador = somadocpf/11;
        String auxdigito = digitoverificador+"";
        digitoverificador = Integer.parseInt(auxdigito.charAt(auxdigito.length()-1)+"");
        int cont2=0;

        for(int cont = digitoverificador ; digitoverificador < digitoverificador+11 ; cont++){
            soma2 = Integer.parseInt(arraycpf[cont])*digitoverificador;
        }
        int digitoverificador2 = soma2/11;
        auxdigito = digitoverificador2+"";
        digitoverificador2 = Integer.parseInt(auxdigito.charAt(auxdigito.length()-1)+"");
         
    }
}
