package controller;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class telaInicialAdmController {

    private static int comboboxvalue;

    public static int getComboboxvalue() {
        return comboboxvalue;
    }

    public static void setComboboxvalue(int comboboxvalue) {
        telaInicialAdmController.comboboxvalue = comboboxvalue;
    }

     @FXML
    private Label lblsair;

    @FXML
    private Button btnsair;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnPesquisa;

    @FXML
    private ComboBox<String> comboBox;

     @FXML
    private Rectangle background;

    @FXML
    private TextField txtPesquisa;

    @FXML
    private Button btnEmprestimo;

    @FXML
    void PesquisarAcervo(ActionEvent event) throws IOException {

        String pesquisa = txtPesquisa.getText();
        System.out.println("pesquis = " + pesquisa + "  index =" + comboboxvalue);
        comboboxvalue = comboBox.getSelectionModel().getSelectedIndex();

        if (comboBox.getValue() == null) {
            comboboxvalue = 5;
        }
        if (comboboxvalue != 0 && comboboxvalue != 1 && comboboxvalue != 2 && comboboxvalue != 5) {
            Alert alerta = new Alert(AlertType.WARNING);
            alerta.setHeaderText("Erro ao pesquisar livro!");
            alerta.setContentText("selecione termo para pesquisa!");
            alerta.show();

        } else {

            URL url = getClass().getResource("/view/paginaCRUD.fxml");
            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            paginaCRUDController controller = loader.getController();

            controller.lblResultado.setText("Resultados para '" + txtPesquisa.getText() + "'");

            controller.initialize(pesquisa);

            Stage stgAcervo = new Stage();
            stgAcervo.setTitle("Página Inicial");
            stgAcervo.setScene(new Scene(root));
            stgAcervo.show();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        }
    }

    @FXML
    void adicionarLivro(ActionEvent event) throws IOException {
        paginaCRUDController.setDeleteeedit(5);
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

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void verEmprestimo(ActionEvent event) throws IOException {
        
        URL url = getClass().getResource("/view/telaLivrosEmprestados.fxml");
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
        comboBox.getItems().addAll("Autor", "Editora", "Título");
        btnsair.setBackground(null);
        

    }
    @FXML
    void clickbtnsair(ActionEvent event) throws IOException {
        PaginaLoginController.setLogado(null);
        URL url = getClass().getResource("/view/paginaInicial.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();

        Stage stgAcervo = new Stage();
        stgAcervo.setTitle("Página Inicial");
        stgAcervo.setScene(new Scene(root));
        stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
