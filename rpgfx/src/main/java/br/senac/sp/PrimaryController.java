package br.senac.sp;

import br.senac.sp.model.Jogador;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField textFieldNome;
    @FXML private TextField textFieldXp;
    @FXML private TextField textFieldHp;
    @FXML private CheckBox checkBoxEnvenenado;

    public void salvar(){
        System.out.println("Salvando jogador... " + textFieldNome.getText());

        var jogador = new Jogador(textFieldNome.getText(), 
                    Integer.valueOf(textFieldXp.getText()), 
                    Integer.valueOf(textFieldHp.getText()), 
                    checkBoxEnvenenado.isSelected()
                );
        System.out.println(jogador);

    }
    
}
