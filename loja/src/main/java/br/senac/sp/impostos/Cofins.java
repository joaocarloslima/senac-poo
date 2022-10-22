package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class Cofins extends Imposto {

    public Cofins(Imposto outroImposto) {
        super(outroImposto);
    }

    @Override
    public BigDecimal calcular(Pedido pedido) {
        var imposto = pedido.getValor().multiply(new BigDecimal(0.07));
        if (outroImposto != null) imposto.add(outroImposto.calcular(pedido));
        return imposto;
    }

    @Override
    public String toString() {
        return "Cofins";
    }

    
    
}
