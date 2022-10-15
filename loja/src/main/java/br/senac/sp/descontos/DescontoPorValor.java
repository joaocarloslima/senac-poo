package br.senac.sp.descontos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class DescontoPorValor extends Desconto {

    public DescontoPorValor(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal calcular(Pedido pedido) {
        return pedido.getValor().multiply(new BigDecimal(0.05));
    }

    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
        return pedido.getValor().compareTo(new BigDecimal(500)) > 0;
    }
    
}
