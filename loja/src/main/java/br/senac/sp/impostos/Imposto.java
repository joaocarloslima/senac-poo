package br.senac.sp.impostos;

import java.math.BigDecimal;

import br.senac.sp.model.Pedido;

public interface Imposto {

    BigDecimal calcular(Pedido pedido);

}
