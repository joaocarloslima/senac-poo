package br.senac.sp.descontos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public class DescontoPorQuantidade extends Desconto {
    
    public DescontoPorQuantidade(Desconto proximo) {
        super(proximo);
    }

    @Override
    protected BigDecimal calcular(Pedido pedido) {
        return pedido.getValor().multiply(new BigDecimal(0.1));
    }

    @Override
    protected boolean podeAplicarDesconto(Pedido pedido) {
         return pedido.getQtdeDeItens() > 5;
    }

}
