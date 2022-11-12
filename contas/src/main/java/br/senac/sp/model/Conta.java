package br.senac.sp.model;

public class Conta {

    private int id;
    private String descricao;
    private double valor;

    public Conta(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Conta(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

}
