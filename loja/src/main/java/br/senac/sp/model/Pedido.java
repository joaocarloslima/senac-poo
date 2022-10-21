package br.senac.sp.model;

import java.math.BigDecimal;

import br.senac.sp.exception.StatusException;

public class Pedido {
    
    private String nome;
    private BigDecimal valor;
    private int qtdeDeItens;
    private Status status = Status.ABERTO;

    public Pedido(String nome, BigDecimal valor, int qtdeDeItens) {
        this.nome = nome;
        this.valor = valor;
        this.qtdeDeItens = qtdeDeItens;
    }

    public String abrirChamado(){
        if (this.status == Status.ABERTO) return "Chamado para FINANCEIRO";
        if (this.status == Status.PAGO) return "Chamado para LOGISTICA";
        if (this.status == Status.ENTREGUE) return "Chamado para PÓS VENDA";
        if (this.status == Status.CANCELADO) return "Chamado para VENDAS";
        return "";
    }

    public void pagar() throws StatusException{
        if (this.status == Status.ABERTO) 
            this.status = Status.PAGO;
        else
            throw new StatusException("Não pode pagar pedido que não está aberto");
    }

    public void entregar() throws StatusException{
        if (this.status == Status.PAGO) 
            this.status = Status.ENTREGUE;
        else
            throw new StatusException("Não pode entregar pedido que não está pago");
    }

    public void cancelar() throws StatusException{
        if (this.status == Status.ABERTO || this.status == Status.PAGO)
            this.status = Status.CANCELADO;
        else
            throw new StatusException("Não pode cancelar pedido " + this.status);
    }

    public void reabrir() throws StatusException{
        if (this.status == Status.CANCELADO) 
            this.status = Status.ABERTO;
        else
            throw new StatusException("Não pode reabrir pedido " + this.status);
    }






    public Status getStatus() {
        return status;
    }

    
    public int getQtdeDeItens() {
        return qtdeDeItens;
    }


    public String getNome() {
        return nome;
    }
    
    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Pedido [nome=" + nome + ", valor=" + valor + "]";
    }

    

}
