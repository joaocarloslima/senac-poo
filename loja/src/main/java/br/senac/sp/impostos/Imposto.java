package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public abstract class Imposto {

    protected Imposto outroImposto;

    public Imposto(Imposto outroImposto) {
        this.outroImposto = outroImposto;
    }

    public abstract BigDecimal calcular(Pedido pedido);

}
