package br.senac.sp;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import br.senac.sp.dao.ContaDAO;
import br.senac.sp.model.Conta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PrimaryController implements Initializable {

    @FXML TextField textFieldDescricao;
    @FXML TextField textFieldValor;
    @FXML TableView<Conta> tabela;

    @FXML TableColumn<Conta, Integer> colunaId;
    @FXML TableColumn<Conta, String> colunaDescricao;
    @FXML TableColumn<Conta, Double> colunaValor;

    @FXML Button botaoSalvar;
    @FXML Button botaoApagar;
    @FXML Button botaoCancelar;

    private ContaDAO dao = new ContaDAO();

    private Conta contaSelecionada = null;

    public void salvar(){
        var conta = new Conta(
            textFieldDescricao.getText(), 
            Double.valueOf(textFieldValor.getText())
        ); 
        try{
            if (contaSelecionada == null ){
                dao.inserir(conta);
            }else{
               atualizar();
            }
            
        }catch(SQLException e){
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
        carregar();
    }

    public void carregar(){
        try {
            tabela.getItems().setAll(dao.listarTodas());
            contaSelecionada = null;
            atualizarView();
        } catch (SQLException e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void apagar(){
        try {
            dao.apagar(contaSelecionada);
            carregar();
        } catch (SQLException e) {
            mostrarMensagem("Erro. " + e.getMessage(), AlertType.ERROR);
        }
    }

    public void atualizar(){
        var conta = new Conta(
            contaSelecionada.getId(),
            textFieldDescricao.getText(),
            Double.valueOf(textFieldValor.getText())
        );
        try {
            dao.atualizar(conta);
            carregar();
        } catch (SQLException e) {
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

        botaoApagar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/delete.png"))));
        botaoSalvar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/salvar.png"))));
        botaoCancelar.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("icons/cancel.png"))));

        carregar();
    }

    public void mostrarMensagem(String mensagem, AlertType tipo){
        var alerta = new Alert(tipo);
        alerta.setContentText(mensagem);
        alerta.show();
    }


}
