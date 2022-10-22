package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

//Design Pattern - Strategy
public class Ipi extends Imposto {
    
    public Ipi(Imposto outroImposto) {
        super(outroImposto);
    }

    public BigDecimal calcular(Pedido pedido){
        var imposto = pedido.getValor().multiply(new BigDecimal(0.03));
        if (outroImposto != null) imposto.add(outroImposto.calcular(pedido));
        return imposto;
    }

    @Override
    public String toString() {
        return "Ipi";
    }

    

}
