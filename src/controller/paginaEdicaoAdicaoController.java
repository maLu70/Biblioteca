package controller;

import dao.LivroDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Livro;
import controller.*;

public class paginaEdicaoAdicaoController {


    @FXML
    public Button btnAdicaoEdicao;

    @FXML
    public Label lblAdicaoEdicao;

    @FXML
    private TextField txtAutor;

    @FXML
    private TextField txtCopias;

    @FXML
    private TextField txtEditora;

    @FXML
    private TextField txtPubli;

    @FXML
    private TextField txtTitulo;


    
        @FXML
        void initialize() {
                if (paginaCRUDController.getDeleteeedit()==1) {
            //         btnAdicaoEdicao.setText("Editar");
            //         lblAdicaoEdicao.setText("Edite seu Livro!");
            //         txtAutor.setText(paginaCRUDController.getLivro().getAutor()); 
            //         txtCopias.setText(paginaCRUDController.getLivro().getNCopias()+"");
            //         txtEditora.setText(paginaCRUDController.getLivro().getEditora());
            //         txtPubli.setText(paginaCRUDController.getLivro().getAnoPublicacao()+"");
            //         txtTitulo.setText(paginaCRUDController.getLivro().getTitulo());
            }else if(paginaCRUDController.getDeleteeedit()==5){
                
                btnAdicaoEdicao.setText("Adicionar");
                lblAdicaoEdicao.setText("Adicione seu livro");
            }
        }
    
    
        @FXML
        void adicaoEdicao(ActionEvent event) {
    
            if (btnAdicaoEdicao.getText() == "Adicionar") {
    
                if (txtAutor.getText() != null && txtCopias.getText() != null && txtEditora.getText() != null
                        && txtPubli.getText() != null && txtTitulo.getText() != null) {
    
                    Livro livro = new Livro(Integer.parseInt(txtPubli.getText()), Integer.parseInt(txtCopias.getText()),
                            txtTitulo.getText(), txtEditora.getText(),  txtAutor.getText(), "Livre");
    
                    LivroDao.cadastrarLivro(livro);
                    System.out.println("livro adicionado");
    
                    txtAutor.setText(null); 
                    txtCopias.setText(null);
                    txtEditora.setText(null);
                    txtPubli.setText(null);
                    txtTitulo.setText(null);
    
                } else {
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setHeaderText("Erro no Cadastro de Livro");
                    alerta.setContentText("Preencha totas as informações corretamente");
                    alerta.show();
                }
            } else if (paginaCRUDController.getDeleteeedit()==1) {
               
            }

   
    }
   
}
