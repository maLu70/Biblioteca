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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class telaInicialAdmController {

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnPesquisa;

    @FXML
    private ComboBox<?> comboBox;

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
    }

    @FXML
    void adicionarLivro(ActionEvent event) throws IOException {
        URL url = getClass().getResource("/view/paginaEdicaoAdicao.fxml");

        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAdicionar = new Stage();
        stgAdicionar.setTitle("Página Inicial");
        stgAdicionar.setScene(new Scene(root));
        stgAdicionar.show();

        paginaEdicaoAdicaoController controller = loader.getController();

        controller.btnAdicaoEdicao.setText("Adicionar");
        controller.lblAdicaoEdicao.setText("Adicionar Livro");

    }

}
