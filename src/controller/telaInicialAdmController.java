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
    void PesquisarAcervo(ActionEvent event) {

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
