package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class Icms implements Imposto {

    public BigDecimal calcular(Pedido pedido){
        return pedido.getValor().multiply(new BigDecimal(1.05));
    }

    @Override
    public String toString() {
        return "Icms";
    }

    
    
}
