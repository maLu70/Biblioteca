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
import javafx.stage.Stage;

public class PaginaInicialController {

    private static int comboboxvalue;

    private static String pesquisa; 

    public static String getPesquisa() {
        return pesquisa;
    }

    public static void setPesquisa(String pesquisa) {
        PaginaInicialController.pesquisa = pesquisa;
    }

    public static int getComboboxvalue() {
        return comboboxvalue;
    }

    public static void setComboboxvalue(int comboboxvalue) {
        PaginaInicialController.comboboxvalue = comboboxvalue;
    }

    @FXML
    private Button btnEntrar;

    @FXML
    private Button btnPesquisa;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label lblBemVindo;

    @FXML
    private TextField txtPesquisa;

    @FXML
    void PesquisarAcervo(ActionEvent event) throws IOException {

        setPesquisa(txtPesquisa.getText());
        System.out.println("pesquis = " + getPesquisa() + "  index =" + comboboxvalue);
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

            URL url = getClass().getResource("/view/paginaAcervo.fxml");

            FXMLLoader loader = new FXMLLoader(url);
            Parent root = loader.load();

            Stage stgAcervo = new Stage();
            stgAcervo.setTitle("Acervo");
            stgAcervo.setScene(new Scene(root));
            stgAcervo.show();

        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
        }
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
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();

    }

    @FXML
    void initialize() {
        comboBox.getItems().addAll("Autor", "Editora", "Título");
        btnEntrar.setBackground(lblBemVindo.getBackground());
    }
}
