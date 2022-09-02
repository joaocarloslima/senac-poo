package model;

public class ContaCorrente extends Conta {
    
    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public ContaCorrente(int numero) {
        super(numero);
    }
    
}
