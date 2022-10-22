package br.senac.sp.status;

import br.senac.sp.model.Pedido;

public class Pago extends Status {

    public Pago(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void cancelar() {
        this.pedido.setStatus(new Cancelado(pedido));
    }

    @Override
    public void entregar() {
        this.pedido.setStatus(new Entregue(pedido));
    }

    @Override
    public String abrirChamado() {
        return "Abrir chamado para LOGÍSTICA";
    }

    
    
}
