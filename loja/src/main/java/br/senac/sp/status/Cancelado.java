package br.senac.sp.status;

import br.senac.sp.model.Pedido;

public class Cancelado extends Status {

    public Cancelado(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void reabrir() {
        this.pedido.setStatus(new Aberto(pedido));
    }

    @Override
    public String abrirChamado() {
        return "Abrir chamado para VENDAS";
    }

    
    
}
