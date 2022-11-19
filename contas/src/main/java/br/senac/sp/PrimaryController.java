package br.senac.sp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.senac.sp.dao.CategoriaDAO;
import br.senac.sp.dao.ContaDAOMemory;
import br.senac.sp.dao.ContaDAOMySql;
import br.senac.sp.dao.ContaDaoInterface;
import br.senac.sp.model.Categoria;
import br.senac.sp.model.Conta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable {

    @FXML TextField textFieldDescricao;
    @FXML TextField textFieldValor;
    @FXML ChoiceBox<Categoria> choiceBoxCategoria;
    @FXML TableView<Conta> tabela;

    @FXML TableColumn<Conta, Integer> colunaId;
    @FXML TableColumn<Conta, String> colunaDescricao;
    @FXML TableColumn<Conta, Double> colunaValor;
    @FXML TableColumn<Conta, Categoria> colunaCategoria;

    @FXML Button botaoSalvar;
    @FXML Button botaoApagar;
    @FXML Button botaoCancelar;

    @FXML TextField textFieldNomeCategoria;
    @FXML Button botaoSalvarCategoria;
    @FXML TableView<Categoria> tabelaCategoria;
    @FXML TableColumn<Categoria, Integer> colunaIdCategoria;
    @FXML TableColumn<Categoria, String> colunaIdNomeCategoria;

    private ContaDaoInterface contaDao;
    private CategoriaDAO categoriaDao;

    private Conta contaSelecionada = null;

    public PrimaryController(){
        try {
            contaDao = new ContaDAOMySql();
            categoriaDao = new CategoriaDAO();
        } catch (Exception e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void salvar(){
        var conta = new Conta(
            textFieldDescricao.getText(), 
            Double.valueOf(textFieldValor.getText()),
            choiceBoxCategoria.getValue()
        ); 
        try{
            if (contaSelecionada == null ){
                contaDao.inserir(conta);
            }else{
               atualizar();
            }
            
        }catch(Exception e){
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
        carregar();
    }

    public void salvarCategoria(){
        try {
            categoriaDao.inserir(
                new Categoria(textFieldNomeCategoria.getText())
            );
            carregar();
        } catch (Exception e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void carregar(){
        try {
            tabela.getItems().setAll(contaDao.listarTodas());
            tabelaCategoria.getItems().setAll(categoriaDao.listarTodas());
            contaSelecionada = null;
            atualizarView();
        } catch (Exception e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void apagar(){
        try {
            contaDao.apagar(contaSelecionada);
            carregar();
        } catch (Exception e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void apagarCategoria(){
        try {
            categoriaDao.apagar(tabelaCategoria.getSelectionModel().getSelectedItem());
            carregar();
        } catch (SQLException e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void atualizar(){
        var conta = new Conta(
            contaSelecionada.getId(),
            textFieldDescricao.getText(),
            Double.valueOf(textFieldValor.getText()),
            choiceBoxCategoria.getValue()
        );
        try {
            contaDao.atualizar(conta);
            carregar();
        } catch (Exception e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void limpar(){
        textFieldDescricao.setText("");
        textFieldValor.setText("");
        contaSelecionada = null;
        atualizarView();
    }

    public void carregarContaNoFormulario(){
        contaSelecionada = tabela.getSelectionModel().getSelectedItem();
        textFieldDescricao.setText(contaSelecionada.getDescricao());
        textFieldValor.setText(String.valueOf(contaSelecionada.getValor()));
        atualizarView();
    }

    public void atualizarView(){
        botaoSalvar.setText(contaSelecionada == null? "inserir":"atualizar");
        botaoApagar.setDisable(contaSelecionada == null);
        botaoCancelar.setDisable(contaSelecionada == null);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));

        colunaIdCategoria.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaIdNomeCategoria.setCellValueFactory(new PropertyValueFactory<>("nome"));

        botaoApagar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/delete.png"))));
        botaoSalvar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/salvar.png"))));
        botaoCancelar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/cancel.png"))));

        try {
            choiceBoxCategoria.getItems().setAll(categoriaDao.listarTodas());
        } catch (SQLException e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }

        carregar();
    }

    public void mostrarMensagem(String mensagem, AlertType tipo){
        var alerta = new Alert(tipo);
        alerta.setContentText(mensagem);
        alerta.show();
    }


}
