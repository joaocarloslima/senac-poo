package br.senac.sp.service;

import java.math.BigDecimal;

import br.senac.sp.descontos.Desconto;
import br.senac.sp.descontos.DescontoPorDia;
import br.senac.sp.descontos.DescontoPorQuantidade;
import br.senac.sp.descontos.DescontoPorValor;
import br.senac.sp.descontos.SemDesconto;
import br.senac.sp.impostos.Imposto;
import br.senac.sp.model.Pedido;

public class PedidoService {

    public BigDecimal calcularValorComImposto(Pedido pedido, Imposto imposto){
       return imposto.calcular(pedido);
    }

    public BigDecimal calcularDesconto(Pedido pedido){
        Desconto cadeiaDeDesconto = 
            new DescontoPorQuantidade(
            new DescontoPorValor(
            new DescontoPorDia(
            new SemDesconto()
        )));

        return cadeiaDeDesconto.calcularDesconto(pedido);
    }
    
}
