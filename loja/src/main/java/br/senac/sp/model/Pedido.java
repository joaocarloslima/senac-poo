package br.senac.sp.model;

import java.math.BigDecimal;

public class Pedido {
    
    private String nome;
    private BigDecimal valor;
    private int qtdeDeItens;

    public Pedido(String nome, BigDecimal valor, int qtdeDeItens) {
        this.nome = nome;
        this.valor = valor;
        this.qtdeDeItens = qtdeDeItens;
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
