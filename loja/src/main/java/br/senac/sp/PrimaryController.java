package br.senac.sp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.ResourceBundle;

import br.senac.sp.exception.StatusException;
import br.senac.sp.impostos.Cofins;
import br.senac.sp.impostos.Icms;
import br.senac.sp.impostos.Imposto;
import br.senac.sp.impostos.Ipi;
import br.senac.sp.model.Pedido;
import br.senac.sp.model.TipoImposto;
import br.senac.sp.service.PedidoService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController implements Initializable {

    @FXML private TextField textFieldNome;
    @FXML private TextField textFieldValor;
    @FXML private TextField textFieldItens;
    @FXML private Label labelTotal;
    @FXML private Label labelDesconto;
    @FXML private ChoiceBox<Imposto> choiceBoxTibutacao;
    @FXML private Label labelStatus;

    private PedidoService service = new PedidoService();
    private Pedido pedido;

    public void pagar(){
        try {
            pedido.pagar();
            labelStatus.setText(pedido.getStatus().toString());
        }catch(StatusException e){
            mostrarMensagem(e.getMessage());
        }
    }

    public void entregar(){
        try {
            pedido.entregar();
            labelStatus.setText(pedido.getStatus().toString());
        }catch(StatusException e){
            mostrarMensagem(e.getMessage());
        }
    }

    public void cancelar(){
        try {
            pedido.cancelar();
            labelStatus.setText(pedido.getStatus().toString());
        }catch(StatusException e){
            mostrarMensagem(e.getMessage());
        }
    }

    public void reabrir(){
        try {
            pedido.reabrir();
            labelStatus.setText(pedido.getStatus().toString());
        }catch(StatusException e){
            mostrarMensagem(e.getMessage());
        }
    }

    private void mostrarMensagem(String mensagem){
        var alerta = new Alert(AlertType.ERROR);
        alerta.setContentText(mensagem);
        alerta.show();
    }

    public void calcular(){
        
        pedido = carregarPedidoDoFormularios();
        Imposto imposto = new Ipi(new Icms(new Cofins(null)));

        var valorComImposto = service.calcularValorComImposto(pedido, imposto);
        labelTotal.setText("R$ " + valorComImposto.setScale(2, RoundingMode.HALF_UP).toString());

        var desconto = service.calcularDesconto(pedido);
        labelDesconto.setText("R$ " + desconto.setScale(2, RoundingMode.HALF_UP).toString());

    }

    private Pedido carregarPedidoDoFormularios(){
        String nome = textFieldNome.getText();
        BigDecimal valor = new BigDecimal( textFieldValor.getText() );
        int qtdeDeItens = Integer.valueOf(textFieldItens.getText());
        return new Pedido(nome, valor, qtdeDeItens);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        choiceBoxTibutacao.getItems().addAll(new Icms(), new Ipi(), new Confins());
    }

}
