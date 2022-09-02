package model;

public class Conta {
    private int numero;
    protected double saldo;
    
    public Conta(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }


}
