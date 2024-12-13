package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PaginaInicialController {

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnPesquisa;

    @FXML
    private ComboBox<?> comboBox;

    @FXML
    private Label lblBemVindo;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void PesquisarAcervo(ActionEvent event) throws IOException {

        String pesquisa = txtPesquisa.getText();
        System.out.println("pesquis = " + pesquisa);

        URL url = getClass().getResource("/view/paginaAcervo.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        paginaAcervoController controller = loader.getController();

        controller.initialize(pesquisa);;

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página Inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        // List<Livro> lst = LivroDao.listar(txtPesquisa.getText());

    }

    @FXML
    void clickLogin(ActionEvent event) throws IOException {
        
        URL url = getClass().getResource("/view/paginaLogin.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Pagina de Login");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();


        paginaAcervoController controller = loader.getController();
    }

    
}
