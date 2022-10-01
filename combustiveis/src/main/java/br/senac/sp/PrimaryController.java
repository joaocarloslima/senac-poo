package br.senac.sp;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML private Label labelResultado;
    @FXML private TextField textFieldPrecoDoAlcool;
    @FXML private TextField textFieldPrecoDaGasolina;

    public void analisar(){
        try{
            double precoDoAlcool = Double.valueOf(textFieldPrecoDoAlcool.getText());
            double precoDaGasolina = Double.valueOf(textFieldPrecoDaGasolina.getText());
    
            if ( precoDoAlcool / precoDaGasolina < 0.7){
                labelResultado.setText("É melhor abastecer com ÁLCOOL");
            }else{
                labelResultado.setText("É melhor abastecer com GASOLINA");
            }
        }catch(NumberFormatException e){
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Preço inválido. Digite apenas números no formato 4.50");
            alerta.show();
        }
    }
    
}
