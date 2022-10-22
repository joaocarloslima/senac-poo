package br.senac.sp.status;

import br.senac.sp.model.Pedido;

public class Entregue extends Status {

    public Entregue(Pedido pedido) {
        super(pedido);
    }

    @Override
    public String abrirChamado() {
        return "Abrir chamado para PÓS VENDA";
    }

}
