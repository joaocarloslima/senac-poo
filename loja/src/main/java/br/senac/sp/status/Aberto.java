package br.senac.sp.status;

import br.senac.sp.model.Pedido;

public class Aberto extends Status{
    
    public Aberto(Pedido pedido) {
        super(pedido);
    }

    public void pagar(){
        this.pedido.setStatus(new Pago(pedido));
    }

    public void cancelar(){
        this.pedido.setStatus(new Cancelado(pedido));
    }

    @Override
    public String abrirChamado() {
        return "Abrir chamado para FINANCEIRO";
    }

}
