package controller;

import dao.LivroDao;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Livro;

import java.io.IOException;
import java.net.URL;

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
                    if (paginaCRUDController.getLivro()!=null) {
                        txtAutor.setText(paginaCRUDController.getLivro().getAutor()); 
                        txtCopias.setText(paginaCRUDController.getLivro().getNCopias()+"");
                        txtEditora.setText(paginaCRUDController.getLivro().getEditora());
                        txtPubli.setText(paginaCRUDController.getLivro().getAnoPublicacao()+"");
                        txtTitulo.setText(paginaCRUDController.getLivro().getTitulo());
                    }
                btnAdicaoEdicao.setText("Editar");
                lblAdicaoEdicao.setText("Edite seu Livro!");
                
            }else if(paginaCRUDController.getDeleteeedit()==5){
                
                btnAdicaoEdicao.setText("Adicionar");
                lblAdicaoEdicao.setText("Adicione seu livro");
            }
        }
    
    
        @FXML
        void adicaoEdicao(ActionEvent event) throws IOException {
    
            if (paginaCRUDController.getDeleteeedit()==5) {
    
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
                if (txtAutor.getText() != null && txtCopias.getText() != null && txtEditora.getText() != null
                        && txtPubli.getText() != null && txtTitulo.getText() != null) {
    
                    Livro livro = new Livro(Integer.parseInt(txtPubli.getText()), Integer.parseInt(txtCopias.getText()),
                            txtTitulo.getText(), txtEditora.getText(),  txtAutor.getText(), "Livre");
                            livro.setIdLivro(paginaCRUDController.getLivro().getIdLivro());
    
                    LivroDao.atualizarLivro(livro, livro.getAnoPublicacao(), livro.getAnoPublicacao(), livro.getTitulo(), livro.getEditora(), livro.getAutor());


                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setHeaderText("Atualização Realizado com Sucesso");
                    alerta.setContentText("O livro foi atualizado com sucesso no sistema.");
                    alerta.show();

                    URL url = getClass().getResource("/view/paginaCRUD.fxml");
                    FXMLLoader loader = new FXMLLoader(url);
                    Parent root = loader.load();
                    Stage stgAcervo = new Stage();
                    stgAcervo.setTitle("Página CRUD");
                    stgAcervo.setScene(new Scene(root));
                    stgAcervo.show();
                    Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    currentStage.close();

    
                } else {
                    Alert alerta = new Alert(AlertType.INFORMATION);
                    alerta.setHeaderText("Erro no Cadastro de Livro");
                    alerta.setContentText("Preencha totas as informações corretamente");
                    alerta.show();
                }
                
            }

   
    }
   
}
