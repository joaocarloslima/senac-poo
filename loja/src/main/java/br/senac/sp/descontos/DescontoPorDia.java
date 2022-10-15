package br.senac.sp.descontos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class DescontoPorDia extends Desconto {

    public DescontoPorDia(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal calcular(Pedido pedido) {
        return new BigDecimal(1);
    }

    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
        return false;
    }
    
}
