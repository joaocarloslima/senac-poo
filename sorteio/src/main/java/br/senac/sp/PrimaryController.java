package br.senac.sp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField textFieldAposta;
    @FXML private Label labelResultado;
    @FXML private Label labelVidas;

    int vidas = 5;

    public void sortear(){
        int aposta = Integer.valueOf( textFieldAposta.getText() );

        int sorteio = (int) ((Math.random() * 6) + 1) ;

        if (aposta == sorteio){
            labelResultado.setText("Muito bem. Acerto.");
            vidas++;
        }else{
            labelResultado.setText("Você errou. O valor era " + sorteio);
            vidas--;
        }

        labelVidas.setText("Vidas: " + vidas);
    }

}
