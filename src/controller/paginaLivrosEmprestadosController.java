package controller;

import java.sql.Date;

import dao.EmprestimoDao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.*;

public class paginaLivrosEmprestadosController {

    @FXML
    private TableColumn<Livro, String> autor;

    @FXML
    private Button btnDevolucao;

    @FXML
    private Button btnVoltar;

    @FXML
    private TableColumn<Emprestimo, Integer> codigo;

    @FXML
    private TableColumn<Emprestimo, Date> devolucao;

    @FXML
    private TableColumn<Emprestimo, Date> emprestimo;

    @FXML
    private TableView<Emprestimo> tblEmprestimos;

    @FXML
    private TableColumn<Emprestimo, String> titulo;

    @FXML
    private TableColumn<Emprestimo, String> editora;

    @FXML
    private TableColumn<Emprestimo, Integer> usuario;

    ObservableList<Emprestimo> obsLiv;

    @FXML
    void initialize() {
        btnVoltar.setBackground(tblEmprestimos.getBackground());

        codigo.setCellValueFactory(new PropertyValueFactory<>("idLivro"));
        autor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        devolucao.setCellValueFactory(new PropertyValueFactory<>("dtDevolucao"));
        emprestimo.setCellValueFactory(new PropertyValueFactory<>("dtEmprestimo"));
        titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        usuario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        editora.setCellValueFactory(new PropertyValueFactory<>("editora"));

        obsLiv = FXCollections.observableList(EmprestimoDao.listarEmprestimo());
        System.out.println(obsLiv.size());

        tblEmprestimos.setItems(obsLiv);
    }

    @FXML
    void devolucao(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {

    }
}
