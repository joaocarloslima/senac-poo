package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

//Design Pattern - Strategy
public class Ipi implements Imposto {
    
    public BigDecimal calcular(Pedido pedido){
        return pedido.getValor().multiply(new BigDecimal(1.03));
    }

    @Override
    public String toString() {
        return "Ipi";
    }

    

}
