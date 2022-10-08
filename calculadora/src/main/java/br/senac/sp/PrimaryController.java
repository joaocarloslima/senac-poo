package br.senac.sp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField display;

    private double numero1;
    private String operacao;

    public void digitarNumero(ActionEvent event){
        Button botao = (Button) event.getSource();
        if (display.getText().equals("0")) display.setText("");
        display.setText(display.getText() + botao.getText());
    }

    public void clear(){
        display.setText("0");
    }

    public void raiz(){
        double numero = Double.valueOf( display.getText() );
        double raiz = Math.sqrt(numero);
        display.setText(String.valueOf(raiz));
    }

    public void quadrado(){
        double numero = Double.valueOf( display.getText() );
        double quadrado = Math.pow(numero, 2);
        display.setText(String.valueOf(quadrado));
    }

    public void operacao(ActionEvent event){
        numero1 = Double.valueOf(display.getText());
        operacao = ((Button) event.getSource()).getText();
        clear();
    }

    public void calcular(){
        double numero2 = Double.valueOf(display.getText());
        double resultado = 0;
        
        if (operacao.equals("+")) resultado = numero1 + numero2;
        if (operacao.equals("-")) resultado = numero1 - numero2;
        if (operacao.equals("*")) resultado = numero1 * numero2;
        if (operacao.equals("/")) resultado = numero1 / numero2;

        display.setText(String.valueOf(resultado));
    }


}
