package br.senac.sp.model;

import java.math.BigDecimal;

import br.senac.sp.exception.StatusException;
import br.senac.sp.status.Aberto;
import br.senac.sp.status.Status;

public class Pedido {
    
    private String nome;
    private BigDecimal valor;
    private int qtdeDeItens;
    private Status status;

    public Pedido(String nome, BigDecimal valor, int qtdeDeItens) {
        this.nome = nome;
        this.valor = valor;
        this.qtdeDeItens = qtdeDeItens;
        this.status = new Aberto(this);
    }

    public String abrirChamado(){
        return this.status.abrirChamado();
    }

    public void pagar() throws StatusException{
       this.status.pagar();
    }

    public void entregar() throws StatusException{
        this.status.entregar();
    }

    public void cancelar() throws StatusException{
        this.status.cancelar();
    }

    public void reabrir() throws StatusException{
        this.status.reabrir();
    }



    public void setStatus(Status status) {
        this.status = status;
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
