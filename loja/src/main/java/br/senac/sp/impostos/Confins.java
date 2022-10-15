package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class Confins implements Imposto {

    @Override
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getValor().multiply(new BigDecimal(1.07));
    }

    @Override
    public String toString() {
        return "Cofins";
    }

    
    
}
