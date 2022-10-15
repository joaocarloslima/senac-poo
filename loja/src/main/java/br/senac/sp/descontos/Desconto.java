package br.senac.sp.descontos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public abstract class Desconto {

    protected Desconto proximo;

    public Desconto(Desconto proximo){
        this.proximo = proximo;
    }

    public BigDecimal calcularDesconto(Pedido pedido){
        if(podeAplicarDesconto(pedido)) 
            return calcular(pedido);
        
        return proximo.calcularDesconto(pedido);
    }

    protected abstract BigDecimal calcular(Pedido pedido);
    protected abstract boolean podeAplicarDesconto(Pedido pedido);
    
    
}
