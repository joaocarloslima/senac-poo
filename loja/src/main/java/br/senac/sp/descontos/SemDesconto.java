package br.senac.sp.descontos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class SemDesconto extends Desconto {

    public SemDesconto() {
        super(null);
    }

    @Override
    protected BigDecimal calcular(Pedido pedido) {
        return BigDecimal.ZERO;
    }

    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
        return true;
    }
    
}
