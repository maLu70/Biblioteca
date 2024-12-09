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

        if (VerificarCPF(txtCPF.getText())) {  
        }else{
            lblErroCPF.setText("CPF deve conter 11 caracteres numéricos");
        }
        if (VerificarCPF(txtCPF.getText()) && dpNasci.getValue()!=null && txtEmail.getText().contains("@")&&txtEmail.getText().length()>10 && txtNome.getText()!=null &&txtSenha.getText()!=null) {
          System.out.println("adicionar usuário no BD");  
        }else{
            System.out.println("mensagem de erro");
        }
    }

    public Boolean VerificarCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");


        if (cpf.length() != 11) {
            return false;
        }


        int soma1 =0, soma2=0 ,peso=10, digitoverificador1, digitoverificador2;

        for(int cont = 0 ; cont < 9; cont++){
            soma1 += Integer.parseInt(cpf.substring(cont, cont+1)) * peso--;
        }
        digitoverificador1 = soma1 % 11;
        if (digitoverificador1 < 2) {
            digitoverificador1 = 0;
        }else{
            digitoverificador1 = 11 - digitoverificador1;
        }

       int peso2=11;
       for (int cont=0; cont <10; cont++) {
           soma2 +=Integer.parseInt(cpf.substring(cont, cont+1)) * peso2--;
       }
       digitoverificador2 = soma2%11;
       if(digitoverificador2<2){
            digitoverificador2 = 0;

    }else{
        digitoverificador2 = 11 - digitoverificador2;
    }

    return  cpf.charAt(9) == (char) (digitoverificador1 + '0') && cpf.charAt(10) == (char) (digitoverificador2 + '0');
}public boolean verificadordesenha(String senha){
    return true;
    //fazer
}
}