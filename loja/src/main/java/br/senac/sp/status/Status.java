package br.senac.sp.status;

import br.senac.sp.exception.StatusException;
import br.senac.sp.model.Pedido;

public abstract class Status {

    protected Pedido pedido;

    public Status(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public abstract String abrirChamado();

    public void pagar(){
        throw new StatusException("Não pode entregar");
    }

    public void entregar(){
        throw new StatusException("Não pode entregar");
    }

    public void cancelar(){
        throw new StatusException("Não pode entregar");
    }

    public void reabrir(){
        throw new StatusException("Não pode reabrir");
    }
    
}
